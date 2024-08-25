const fs = require('fs');


const SERVER_URL= 'http://localhost:8080';
const METADATA_ENDPOINT_URL = SERVER_URL + '/api/metadata/describe';

fetch(METADATA_ENDPOINT_URL, {
    method : 'get',
    mode : 'cors',
}).then((response)=>{
    if(response.ok){
        response.json().then((result)=>{
            generateModules(result).then(()=>{
                console.log('Job completed with no errors');
            });
        })
    }
    else{
        console.error('Server did not respond correctly, or there was an error issueing the request');
    }
}).catch((error)=>{
    console.error(error);
})


async function generateModules(metadata){

 const promises = metadata.map(apiDir => createTsModule(apiDir));
    
 await Promise.all(promises);
}

async function createTsModule(apiDir){
    const path = './src/services/' + apiDir.dirName +'.ts';
    fs.writeFileSync(path, generateSourceCode(apiDir));
    console.log('Created file : ' + path);
    
}


function generateSourceCode(apiDir){

    let source = '';
    source += addComment('THIS IS A GENERATED FILE, DO NOT MODIFY', 2);
    source += addComment('This is only to avoid an error in case no endpoint was generated or exported')
    source += declareConst('useless',0,true);
    source += declareConst('SERVER_URL', SERVER_URL);
    source += newLines(2);
    
    source += generateEndpointFunctions(apiDir.controller);
    source += generateModelsInterfaces(apiDir.models);

    return source;
}

function generateEndpointFunctions(controller){
    let source = '';
    const baseEndpointVarName = 'CONTROLLER_BASE_ENDPOINT';
    source += declareConst(baseEndpointVarName, controller.baseEndpoint);
    source += newLines(2);

    for(const endpoint of controller.endpoints){
        source += generateEndpointFunc(baseEndpointVarName, endpoint);
        source += newLines(2);
    }

    return source;

}


function generateEndpointFunc(baseEndpointVarName, endpoint){
    const parameters = [...endpoint.bodyParameters.map((param)=> `${param.fieldName} : ${toTsType(param.fieldType)}`), ...endpoint.pathParameters.map((param)=> `${param.fieldName} : ${toTsType(param.fieldType)}`)].join(',');
    const parameterNames = endpoint.bodyParameters.map((param)=>param.fieldName).join(',');
    
    return `export async function ${endpoint.functionName}(${parameters}):${toTsType(endpoint.returnType)}
    {
        const obj = {${parameterNames}};
        const response = await fetch(\`\${SERVER_URL}\${${baseEndpointVarName.replace(/{/g, '${')}}${endpoint.url.replace(/{/g, '${')}\`,{
            
        method : '${endpoint.method}',
        mode : 'cors'
        ${endpoint.method.toLowerCase() == 'get' ? '' : ',body : JSON.stringify(obj)'}
        });

        if(response.ok){
            return response.json();
        }
        return null;
    }`;
}

function toTsType(javaType) {
    const typeMap = {
        "int": "number",
        "Integer": "number",
        "long": "number",
        "Long": "number",
        "double": "number",
        "Double": "number",
        "float": "number",
        "Float": "number",
        "char": "string",
        "Character": "string",
        "String": "string",
        "boolean": "boolean",
        "Boolean": "boolean",
        "Void": "void",
        "void" : "void"
        // Add more primitive or known types as needed
    };

    // Handle generic types like ArrayList<String>
    const genericTypeRegex = /^(\w+)<(.+)>$/;
    const match = javaType.match(genericTypeRegex);

    if (match) {
        const baseType = match[1];
        const genericArg = match[2];
        const mappedGenericArg = toTsType(genericArg);

        // Special case for ResponseEntity
        if (baseType === "ResponseEntity") {
            return `Promise<${mappedGenericArg} | null>` ; // Just return the mapped generic argument
        }

        if (baseType === "ArrayList" || baseType === "List" || baseType === "Set") {
            return `${mappedGenericArg}[] | null`;
        }

        // Add other generic base types handling if needed
        return `${baseType}<${mappedGenericArg}> | null`; // For custom generics
    }

    // If it's a simple type or a custom class type, map it directly
    return typeMap[javaType] || javaType + ' | null';
}


function generateModelsInterfaces(models){
    let source = '';
    
    for(const objInterface of models.interfaces){
    source += generateInterface(objInterface);
        source += newLines(2);
    }
    return source;
}

function generateInterface(objInterface){
    let source = '';

    const fields = objInterface.fields.map((field)=>`${field.fieldName} : ${field.fieldType}`).join(';\n\t\t');

    source += 
    `interface ${objInterface.interfaceName}{
        ${fields}
    }`

    return source;
}

function newLines(count = 1){
    if(count < 0) return '';
    
    let lines = '';
    while(count != 0 ){
        lines += '\n'; 
        count --;
    }
    
    return lines;
}

function addComment(comment, skipLines = 1){
    return `//${comment}${end(skipLines)}`
}

function declareConst(name, value, withExport = false){
    return `${withExport ? 'export ' : ''}const ${name} = ${typeof value === 'string' ? `'${value}'` : value}${end()}`
}

function end(count = 1){
    return ';' + newLines(count);
}
