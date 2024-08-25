package com.jali.endpoints.ApiMetaData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AnnotationExpr;

@Service
public class ApiMetaDataHelper {

    private class SourceCode {

        public String controllerSource = null;
        public String modelsSource = null;

        @Override
        public String toString() {
            return "Controller Source : " + this.controllerSource + "\nModels Source : " + this.modelsSource;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class Field {

        public String fieldType = null;
        public String fieldName = null;

        public Field() {

        }

        public Field(String fieldType, String fieldName) {
            this.fieldType = fieldType;
            this.fieldName = fieldName;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class Endpoint {

        public String functionName = null;
        public String url = null;
        public String method = null;
        public String returnType = null;
        public List<Field> pathParameters = new ArrayList<>();
        public List<Field> bodyParameters = new ArrayList<>();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class ObjectInterface{
        public String interfaceName = "";
        public List<Field> fields = new ArrayList<>();

        public ObjectInterface(){

        }
        public ObjectInterface(String interfaceName, List<Field> fields) {
            this.interfaceName = interfaceName;
            this.fields = fields;    
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class ControllerIntermediate {

        public String baseEndpoint = null;
        public List<Endpoint> endpoints = new ArrayList<>();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class ModelsIntermediate {
        public List<ObjectInterface> interfaces = new ArrayList<>();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class IntermediateCode {

        public String dirName = null;
        public ControllerIntermediate controller = new ControllerIntermediate();
        public ModelsIntermediate models = new ModelsIntermediate();
    }

    public String getJsonObject() {
        Map<String, SourceCode> source = readSource();
        List<IntermediateCode> intermediateCodes = new ArrayList<>();
        for (String key : source.keySet()) {
            IntermediateCode code = parseSourceCode(source.get(key));
            code.dirName = key;
            intermediateCodes.add(code);
        }
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(intermediateCodes);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    private Map<String, SourceCode> readSource() {
        HashMap<String, SourceCode> sourceMap = new HashMap<>();
        File directory = new File("/home/jafar/Jali/jali-server/src/main/java/com/jali/endpoints"); // Update with your directory path

        if (directory.isDirectory()) {
            File[] folders = directory.listFiles(File::isDirectory);

            if (folders != null) {
                for (File folder : folders) {
                    SourceCode sourceCode = new SourceCode();
                    File[] files = folder.listFiles((dir, name) -> name.toLowerCase().contains("controller") || name.toLowerCase().contains("models"));

                    if (files != null) {
                        for (File file : files) {
                            String fileName = file.getName().toLowerCase();

                            try {

                                if (fileName.contains("controller")) {
                                    String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                                    sourceCode.controllerSource = content;
                                } else if (fileName.contains("models")) {
                                    String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                                    sourceCode.modelsSource = content;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    sourceMap.put(folder.getName(), sourceCode);
                }
            }
        }

        return sourceMap;
    }

    private IntermediateCode parseSourceCode(SourceCode source) {
        IntermediateCode code = new IntermediateCode();
        code.controller = parseController(source.controllerSource);
        code.models = parseModels(source.modelsSource);
        return code;
    }

    private ControllerIntermediate parseController(String controllerSource) {
        ControllerIntermediate controller = new ControllerIntermediate();

        CompilationUnit parsedSource = null;
        if (controllerSource != null) {
            parsedSource = StaticJavaParser.parse(controllerSource);
        } else {
            return controller;
        }

        parsedSource.findAll(ClassOrInterfaceDeclaration.class).forEach(clazz -> {

            System.out.println(clazz.getNameAsString());

            Optional<AnnotationExpr> requestMappingOptional = clazz.getAnnotationByName("RequestMapping");
            if (!requestMappingOptional.isPresent()) {
                throw new RuntimeException("FATAL PARSE ERROR : Controller " + clazz.getNameAsString() + " does not contain a Request Mapping Annotation.");
            }

            AnnotationExpr requestMapping = requestMappingOptional.get();

            if (requestMapping.isSingleMemberAnnotationExpr()) {
                controller.baseEndpoint = requestMapping.toSingleMemberAnnotationExpr().get().getMemberValue().toString().replaceAll("\"", "");
            } else {
                throw new RuntimeException("FATAL PARSE ERROR : Controller " + clazz.getNameAsString() + " Request Mapping Annotation does not contain any value");
            }

            clazz.getMethods().forEach(method -> {
                System.out.println(method.getNameAsString());
                for (AnnotationExpr annotation : method.getAnnotations()) {
                    String name = annotation.getNameAsString();

                    if (name.toLowerCase().contains("mapping")) {
                        Endpoint endpoint = new Endpoint();
                        endpoint.method = name.toUpperCase().replaceAll("MAPPING", "");
                        endpoint.functionName = method.getNameAsString();
                        endpoint.returnType = method.getTypeAsString();

                        if (annotation.isSingleMemberAnnotationExpr()) {
                            endpoint.url = annotation.toSingleMemberAnnotationExpr().get().getMemberValue().toString().replaceAll("\"", "");
                        } else {
                            endpoint.url = "";
                        }

                        for (Parameter param : method.getParameters()) {
                            if(param.getAnnotationByName("PathVariable").isPresent()){
                                endpoint.pathParameters.add(new Field(param.getTypeAsString(), param.getNameAsString()));
                            }
                            else if(param.getAnnotationByName("RequestBody").isPresent()){
                                endpoint.bodyParameters.add(new Field(param.getTypeAsString(), param.getNameAsString()));
                            }
                            else{
                                throw new RuntimeException("REPORT BUG");
                            }
                        }

                        controller.endpoints.add(endpoint);
                        break;
                    }
                }
            });

        });

        return controller;
    }

    private ModelsIntermediate parseModels(String modelsSource) {
        ModelsIntermediate models = new ModelsIntermediate();
        CompilationUnit parsedSource = null;
        if (modelsSource != null) {
            parsedSource = StaticJavaParser.parse(modelsSource);
        } else {
            return models;
        }

        parsedSource.findAll(ClassOrInterfaceDeclaration.class).get(0)
        .findAll(ClassOrInterfaceDeclaration.class).forEach(clazz -> {
            List<Field> fields = new ArrayList<Field>();
            for (FieldDeclaration field : clazz.getFields()) {
                for (VariableDeclarator var : field.getVariables()) {
                    fields.add(new Field(var.getTypeAsString(), var.getNameAsString()));
                }
            }
            models.interfaces.add(new ObjectInterface(clazz.getNameAsString(), fields));
        });

        return models;
    }

}
