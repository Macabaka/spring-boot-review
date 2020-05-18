package com.soft1851.springboot.quartz.test;

import org.aspectj.weaver.ast.Test;
import org.quartz.SchedulerException;

/**
 * @author Johnny
 * @Date: 2020/5/18 22:06
 * @Description:
 */
public class DynamicScheduleTask {
    public static void main(String[] args) throws SchedulerException {
        //添加任务，注意各个参数的作用
        QuartzManger.addJob("testJob", "jobGroup",
                "testTrigger", "triggerGroup",
                TestJob.class, 2);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //修改任务
        QuartzManger.modifyJonTime("testTrigger", "triggerGroup", 5);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //删除任务
        QuartzManger.removeJob("testJob","jobGroup","testTrigger","triggerGroup");
        QuartzManger.shutdownJobs();
    }

}
