package com.soft1851.springboot.time.service;

import java.io.ByteArrayOutputStream;
import java.util.Map;

/**
 * @author Johnny
 * @Date: 2020/5/15 17:44
 * @Description:
 */
public interface MailService {



    /**
     * 发送邮件
     * @param to 目的地
     * @param subject 主题
     * @param content 内容
     * @throws Exception
     */
    public void sendMail(String to, String subject, String content, Map<String,String> imgMap, String...filePath);
}
