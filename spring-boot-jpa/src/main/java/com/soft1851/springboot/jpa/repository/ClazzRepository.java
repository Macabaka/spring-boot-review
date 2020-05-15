package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johnny
 * @Date: 2020/5/14 21:29
 * @Description:
 */
public interface ClazzRepository extends JpaRepository<Clazz,Integer> {

    /**
     * 根据id查询clazz
     * @param id
     * @return
     */
    Clazz findClazzById(int id);
}
