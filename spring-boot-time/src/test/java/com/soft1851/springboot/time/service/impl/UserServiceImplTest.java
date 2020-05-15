package com.soft1851.springboot.time.service.impl;

import com.soft1851.springboot.time.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void findById() {
        System.out.println(userService.findById((long) 1));
    }

    @Test
    void findAll(){
        System.out.println(userService.findAll());
    }
}