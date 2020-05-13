package com.soft1851.springboot.jpa.service.impl;

import com.soft1851.springboot.jpa.model.UserDetail;
import com.soft1851.springboot.jpa.service.UserDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailServiceImplTest {

    @Resource
    UserDetailService userDetailService;

    @Test
    void findByCondition() {
        Pageable pageable = PageRequest.of(0,5,Sort.by(Sort.Direction.DESC, "id"));
        Page<UserDetail> userDetailPage = userDetailService.findByCondition("1", pageable);
        Iterator<UserDetail> userDetailIterator = userDetailPage.iterator();
        while (userDetailIterator.hasNext()) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(userDetailIterator.next().getRealName());
        }
    }
}