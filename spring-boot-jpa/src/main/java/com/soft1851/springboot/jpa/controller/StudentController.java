package com.soft1851.springboot.jpa.controller;

import com.soft1851.springboot.jpa.model.Student;
import com.soft1851.springboot.jpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/14 21:31
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

    @Resource
    private StudentRepository studentRepository;

    @GetMapping()
    public List<Student> getStudents(@RequestParam("clazzId") int id) {
        return studentRepository.findStudentByClazzId(id);
    }

    @GetMapping("/user")
    public Student getStudent(@RequestParam("studentId") int id) {
        return studentRepository.findStudentById(id);
    }
}
