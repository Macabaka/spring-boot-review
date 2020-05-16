package com.soft1851.springboot.time.service.impl;

import com.soft1851.springboot.time.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Johnny
 * @Date: 2020/5/16 21:41
 * @Description:
 */
@Service
@Slf4j
public class AsyncTaskService {

    @Resource
    FileUtil fileUtil;

    @Async
    public void asyncTask() {
        log.info("=======================》》其他线程："+Thread.currentThread().getName());
        fileUtil.getMessage();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("上传成功");
    }
}
