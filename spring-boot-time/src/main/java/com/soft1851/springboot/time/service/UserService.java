package com.soft1851.springboot.time.service;

import com.soft1851.springboot.time.model.User;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:58
 * @Description:
 */
public interface UserService {
    User findById(Long id);

    List<User> findAll();
}

