package com.soft1851.springboot.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Johnny
 * @Date: 2020/5/12 20:22
 * @Description:
 */
@Slf4j
public class AfterApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>, Ordered {


    @Override
    public void initialize(C applicationContext) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>After Application.id="+applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
