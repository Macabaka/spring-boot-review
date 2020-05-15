package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Clazz;
import com.soft1851.springboot.jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/14 21:29
 * @Description:
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    Student findStudentById(int id);

    @Query(value = "select id,age from student where  clazz_id = ?1", nativeQuery = true)
    List<Student> findStudentByClazzId(int id);

}
