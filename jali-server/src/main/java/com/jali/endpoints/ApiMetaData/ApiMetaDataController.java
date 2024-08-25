package com.jali.endpoints.ApiMetaData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jali.JaliApplication;

@RestController
@RequestMapping("/api/metadata")
public class ApiMetaDataController {

    private final ApiMetaDataHelper helper;

    @Autowired
    public ApiMetaDataController(ApiMetaDataHelper helper){
        this.helper = helper;
    }

    @GetMapping("/describe")
    public ResponseEntity<String> getApiStructure(){
        String json = helper.getJsonObject();
        JaliApplication.log.info(json);
        return ResponseEntity.ok(json);
    }
}
