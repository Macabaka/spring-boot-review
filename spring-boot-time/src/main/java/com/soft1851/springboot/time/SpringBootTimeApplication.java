package com.soft1851.springboot.time;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
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
//缓存
@EnableMethodCache(basePackages = "com.soft1851.springboot.time")
@EnableCreateCacheAnnotation
public class SpringBootTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTimeApplication.class, args);
    }

}
