package com.soft1851.springboot.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnny
 * @Date: 2020/5/11 21:10
 * @Description:
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello,Spring Boot";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return "hello," + name;
    }

    @GetMapping("/hello1")
    public String  hello1(@RequestParam(name = "name") String name) {
        return "Hello,"+name;
    }
}
