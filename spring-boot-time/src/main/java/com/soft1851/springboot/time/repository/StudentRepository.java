package com.soft1851.springboot.time.repository;

import com.soft1851.springboot.time.model.Student;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johnny
 * @Date: 2020/5/17 00:42
 * @Description:
 */
public interface StudentRepository  extends  JpaRepository<Student,Integer> {
}
