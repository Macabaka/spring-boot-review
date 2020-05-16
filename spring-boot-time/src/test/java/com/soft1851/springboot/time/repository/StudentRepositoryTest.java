package com.soft1851.springboot.time.repository;

import com.soft1851.springboot.time.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Resource
    private StudentRepository studentRepository;

    @Test
    void getTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().name("1").build());
        studentList.add(Student.builder().name("1").build());
        studentList.add(Student.builder().name("1").build());
        studentList.add(Student.builder().name("1").build());
        System.out.println(studentRepository.saveAll(studentList));
    }

}