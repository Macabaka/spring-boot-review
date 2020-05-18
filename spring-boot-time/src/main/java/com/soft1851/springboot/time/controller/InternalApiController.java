package com.soft1851.springboot.time.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Johnny
 * @Date: 2020/5/18 09:23
 * @Description:
 */
@Controller
public class InternalApiController {
    @GetMapping("/internal/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
}
