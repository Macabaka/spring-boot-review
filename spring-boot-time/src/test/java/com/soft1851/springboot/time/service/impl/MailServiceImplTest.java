package com.soft1851.springboot.time.service.impl;

import com.soft1851.springboot.time.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceImplTest {

    @Resource
    MailService mailService;

    @Test
    void sendMail() {
        Map<String, String> imgMap = new HashMap<>();
        String imgPath = "D:\\1.jpg";
        imgMap.put("img01", imgPath);
        try {
            mailService.sendMail("hyyh0369@163.com","我是测试数据","我是测试内容",imgMap,"D:\\application.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}