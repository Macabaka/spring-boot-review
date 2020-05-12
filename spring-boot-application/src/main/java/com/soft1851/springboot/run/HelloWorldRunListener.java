package com.soft1851.springboot.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.admin.SpringApplicationAdminMXBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Johnny
 * @Date: 2020/5/12 18:46
 * @Description:
 */
@Slf4j
public class HelloWorldRunListener implements SpringApplicationRunListener {
    public HelloWorldRunListener(SpringApplication application, String[] args) {
      log.info(">>>>>>>>>>>>>>>>创建HelloWorldRunListener对象...");
    }

    @Override
    public void starting() {
        log.info(">>>>>>>>>>>>>>>>>>>>>HelloWorldRunListener.starting()");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info(">>>>>>>>>>>>>>>>>>>environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>>>>>>>>.contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>>>>>>>>contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>>>>>>>>started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info(">>>>>>>>>>>>>>>>>>>>>running");

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info(">>>>>>>>>>>>>>>>>>>>>failed");

    }
}
