package com.soft1851.springboot.bootstrap;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny
 * @Date: 2020/5/12 18:59
 * @Description:
 */
public class SpringApplicationBootstrap {
    @SpringBootApplication
    public static  class ApplicationConfiguration{

    }

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class)
        Set<String> sources = new HashSet<>();
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        //关闭默认web配置
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.setAdditionalProfiles("dev");
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setHeadless(true);
        springApplication.run(args);
        //另一种启动方式
        //API自定义SpringApplication
//        new SpringApplicationBuilder(ApplicationConfiguration.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .profiles("dev")
//                .headless(true)
//                .run(args);
    }
}
