package com.soft1851.springboot.time.service;

import com.alicp.jetcache.anno.Cached;
import com.soft1851.springboot.time.model.User;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:58
 * @Description:
 */
public interface UserService {

    @Cached(name = "userCache-",key = "#userId",expire = 3600)
    User findById(Long id);

    @Cached(name = "userCache-",key = "#user.userId")
    List<User> findAll();
}

