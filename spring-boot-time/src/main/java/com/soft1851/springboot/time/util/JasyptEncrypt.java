package com.soft1851.springboot.time.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author Johnny
 * @Date: 2020/5/16 22:16
 * @Description:
 */
public class JasyptEncrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密盐
        textEncryptor.setPassword("123456");
        //加密数据
        String username = textEncryptor.encrypt("root");
        System.out.println(username);
    }
}
