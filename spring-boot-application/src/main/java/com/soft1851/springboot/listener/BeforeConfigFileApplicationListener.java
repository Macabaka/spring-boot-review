package com.soft1851.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.env.Environment;

/**
 * @author Johnny
 * @Date: 2020/5/12 20:26
 * @Description:
 */
@Slf4j
public class BeforeConfigFileApplicationListener implements SmartApplicationListener {
    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER-1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return false;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationEnvironmentPreparedEvent){
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = preparedEvent.getEnvironment();
            log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>environment.getProperty(name):"+environment.getProperty("name"));
        }
    }
}
