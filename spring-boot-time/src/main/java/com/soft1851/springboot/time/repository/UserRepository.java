package com.soft1851.springboot.time.repository;

import com.soft1851.springboot.time.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:56
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(Long id);

    @Override
    List<User> findAll();

}
