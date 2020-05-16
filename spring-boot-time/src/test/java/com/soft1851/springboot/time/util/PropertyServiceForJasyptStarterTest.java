package com.soft1851.springboot.time.util;

import com.soft1851.springboot.time.test.JasyptTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest

class PropertyServiceForJasyptStarterTest {

    @Autowired
    JasyptTest service;

    @Autowired
    Environment environment;

    @Test
    void getProperty() {
        System.out.println(service.getProperty());
        System.out.println(service.getPasswordUsingEnvironment(environment));
    }
}