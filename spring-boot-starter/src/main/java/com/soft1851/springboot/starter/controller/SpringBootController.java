package com.soft1851.springboot.starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnny
 * @Date: 2020/5/11 21:10
 * @Description:
 */
@RestController
@RequestMapping("api")
public class SpringBootController {

    @RequestMapping("hello")
    public String hello() {
        return "Hello,Spring Boot!";
    }
}
