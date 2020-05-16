package com.soft1851.springboot.time.test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author Johnny
 * @Date: 2020/5/16 22:40
 * @Description: jasytp测试类
 */
//@Service
public class JasyptTest {

    @Value("{encryptor.property}")
    private  String property;

    public String getProperty(){
        return property;
    }

    public String getPasswordUsingEnvironment(Environment environment) {
        return environment.getProperty("encryptor.property");
    }

}
