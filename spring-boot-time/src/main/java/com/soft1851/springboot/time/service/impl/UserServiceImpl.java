package com.soft1851.springboot.time.service.impl;

import com.soft1851.springboot.time.model.User;
import com.soft1851.springboot.time.repository.UserRepository;
import com.soft1851.springboot.time.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:58
 * @Description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
