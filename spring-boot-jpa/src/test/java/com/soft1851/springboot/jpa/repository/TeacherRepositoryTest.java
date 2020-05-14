package com.soft1851.springboot.jpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class TeacherRepositoryTest {

    @Resource
    TeacherRepository teacherRepository;

    @Test
    void findById() {
        System.out.println(teacherRepository.findById(1));
    }
}