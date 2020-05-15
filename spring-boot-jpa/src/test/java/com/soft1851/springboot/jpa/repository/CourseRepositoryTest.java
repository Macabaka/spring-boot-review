package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Resource
    private CourseRepository courseRepository;

    @Test
    void findCourseByCourseName() {
        System.out.println(courseRepository.findCourseByCourseName("Java"));
    }
}