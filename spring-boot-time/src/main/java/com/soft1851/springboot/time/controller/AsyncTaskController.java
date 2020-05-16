package com.soft1851.springboot.time.controller;

import com.soft1851.springboot.time.service.impl.AsyncTaskService;
import com.soft1851.springboot.time.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author Johnny
 * @Date: 2020/5/16 21:43
 * @Description:
 */
@RestController
@Slf4j
public class AsyncTaskController {

    @Resource
    private AsyncTaskService asyncTaskService;



//    @RequestMapping("/asyncTask")
//    public String asyncTask() {
//        asyncTaskService.asyncTask();
//        return "测试异步任务";
//    }


    @PostMapping("/file")
    public String uploadFile() {
        asyncTaskService.asyncTask();
        log.info("=======================》》主线程："+Thread.currentThread().getName());
        return "文件正在解析";
    }
}
