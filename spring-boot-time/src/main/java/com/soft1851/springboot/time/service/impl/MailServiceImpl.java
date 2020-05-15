package com.soft1851.springboot.time.service.impl;

import com.soft1851.springboot.time.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.persistence.criteria.From;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

/**
 * @author Johnny
 * @Date: 2020/5/15 17:45
 * @Description:
 */
@Service
@Slf4j
public class MailServiceImpl  implements MailService {


    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private  MailService mailService;

    private String from = "2641013950@qq.com";



    @Override
    public void sendMail(String to, String subject, String content,Map<String,String> imgMap, String...filePath)  {
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            //发送html邮件
            helper.setText(content,true);
            //判断有无附件
            if(null!=filePath){
                //循环解决多个附件上传问题
                for (String file : filePath) {
                    FileSystemResource fileSystemResource = new FileSystemResource(new File(file));
                    //判断路径下的文件是否存在
                    if (fileSystemResource != null) {
                        String fileName = fileSystemResource.getFilename();
                        assert fileName != null;
                        helper.addAttachment(fileName, fileSystemResource);
                    }
                }
            }
            //添加图片
            //判断是否有图片
            //log.info(String.valueOf(imgMap));
            if (imgMap!= null) {
                for (Map.Entry<String, String> entry : imgMap.entrySet()) {
                    FileSystemResource fileResource = new FileSystemResource(new File(entry.getValue()));
                    if (fileResource.exists()) {
                        helper.addInline(entry.getKey(),fileResource);
                    }
                }
            }
            javaMailSender.send(message);
//        log.info("邮件发送成功");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
