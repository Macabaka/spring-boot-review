package com.soft1851.springboot.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Resource
    private  StudentRepository studentRepository;

    @Test
    void findStudentById() {
        System.out.println(studentRepository.findStudentById(1));
    }

    @Test
    void findStudentByClazzId() {
        System.out.println(studentRepository.findStudentByClazzId(1));
    }
}