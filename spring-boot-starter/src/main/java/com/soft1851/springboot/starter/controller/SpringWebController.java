package com.soft1851.springboot.starter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Johnny
 * @Date: 2020/5/11 21:10
 * @Description:
 */
@Controller
@RequestMapping("/springWeb")
@ResponseBody
public class SpringWebController {

    @RequestMapping("hello")
    public String hello() {
        return "<h2>Hello,Spring Boot!</h2>";
    }
}
