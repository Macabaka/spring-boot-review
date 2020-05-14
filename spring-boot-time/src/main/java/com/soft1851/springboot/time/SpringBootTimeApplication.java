package com.soft1851.springboot.time;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTimeApplication.class, args);
    }

}
