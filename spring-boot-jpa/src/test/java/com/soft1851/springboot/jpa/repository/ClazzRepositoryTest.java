package com.soft1851.springboot.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClazzRepositoryTest {

    @Resource
    private  ClazzRepository clazzRepository;

    @Test
    void findClazzById() {
        System.out.println(clazzRepository.findClazzById(1));
    }
}