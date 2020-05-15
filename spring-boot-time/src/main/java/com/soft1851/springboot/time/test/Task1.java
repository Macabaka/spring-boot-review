package com.soft1851.springboot.time.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Johnny
 * @Date: 2020/5/14 19:30
 * @Description:
 */
@Component
public class Task1 {
    private  int count =0;

    @Scheduled(cron = "*/5 * * * * ?")
    private void process() {
        System.out.println("定时任务执行:"+count++);
    }
}
