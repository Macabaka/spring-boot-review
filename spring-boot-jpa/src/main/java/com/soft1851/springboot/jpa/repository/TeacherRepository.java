package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Johnny
 * @Date: 2020/5/14 18:18
 * @Description:
 */
public interface TeacherRepository extends JpaSpecificationExecutor<Teacher> , JpaRepository<Teacher,Long> {

     /**
      * 根据id查询教师
      * @param id
      * @return
      */
     Teacher findTeacherById(int id);


}
