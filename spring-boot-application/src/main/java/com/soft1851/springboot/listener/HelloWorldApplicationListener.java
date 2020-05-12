package com.soft1851.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Johnny
 * @Date: 2020/5/12 18:33
 * @Description:
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>refresh applicationContext ,Hello World:" + event.getApplicationContext().getId() + ",timestamp:" + event.getTimestamp());
    }
}
