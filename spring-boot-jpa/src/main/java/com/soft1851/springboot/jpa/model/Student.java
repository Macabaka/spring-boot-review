package com.soft1851.springboot.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/14 17:30
 * @Description:
 */
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "age", nullable = false, length = 30)
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList = new ArrayList<>();
}
