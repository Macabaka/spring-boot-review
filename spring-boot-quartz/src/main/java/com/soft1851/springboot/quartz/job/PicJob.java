package com.soft1851.springboot.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author Johnny
 * @Date: 2020/5/19 01:28
 * @Description:
 */
@DisallowConcurrentExecution
@Component
@Slf4j
public class PicJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("《《《《《《《《《《《《《《《《我是测试语句");
    }
}
