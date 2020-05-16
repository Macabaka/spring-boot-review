package com.soft1851.springboot.time;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//定时任务
@EnableScheduling
//异步
@EnableAsync
//Jasypt加密解密
@EnableEncryptableProperties
public class SpringBootTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTimeApplication.class, args);
    }

}
