package com.jali.endpoints.ApiMetaData;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ApiMetaDataHelperTests {
    
    @Test
    void testHelper(){
        ApiMetaDataHelper helper = new ApiMetaDataHelper();
        System.out.println("------------------START HERE------------------");
        System.out.println(helper.getJsonObject());
        System.out.println("------------------START HERE------------------");
    }
}
