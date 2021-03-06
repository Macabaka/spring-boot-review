package com.soft1851.springboot.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Johnny
 * @Date: 2020/5/12 18:59
 * @Description:
 */
@SpringBootApplication
@Slf4j
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册应用事件监听器
        context.addApplicationListener(event->{
            log.info("监听到事件："+event);
        });
        //启动上下文
        context.refresh();
        //发送事件
        context.publishEvent("HelloWorld");
        context.publishEvent("2020");
        context.publishEvent(new ApplicationEvent("新冠肺炎") {
        });
        //关闭上下文
        context.close();
    }

}
