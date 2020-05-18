package com.soft1851.springboot.time.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnny
 * @Date: 2020/5/18 09:19
 * @Description:
 */
@Controller
public class ExternalApiController {

    @GetMapping("/external/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
}
