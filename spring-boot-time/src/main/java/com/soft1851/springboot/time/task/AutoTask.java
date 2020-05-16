package com.soft1851.springboot.time.task;

import com.soft1851.springboot.time.model.User;
import com.soft1851.springboot.time.repository.CronRepository;
import com.soft1851.springboot.time.repository.UserRepository;
import com.soft1851.springboot.time.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:15
 * @Description:
 */
//@Slf4j
//@Configuration
public class AutoTask {
//    0/3 * * * * ?

//    @Resource
////    private CronRepository cronRepository;
////    @Resource
////    private MailService mailService;
////    @Resource
////    private UserRepository userRepository;
////
////    private List<User> users;
////
////    @Override
////    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        users = userRepository.findAll();
//        taskRegistrar.addTriggerTask(this::process,triggerContext -> {
//            //查询id为1的cron
//            String cron = cronRepository.findCronByCronId(1).getCron();
//            log.info(cron);
//            if (cron.isEmpty()){
//                log.info("cron为空");
//            }
//            return new CronTrigger(cron).nextExecutionTime(triggerContext);
//        });
//    }


//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(()->{
//            //定时任务内容
//            log.info("执行定时任务");
//        },triggerContext -> {
//            log.info("测试语句");
//            return new CronTrigger("0/3 * * * * ?").nextExecutionTime(triggerContext);
//        });
//    }

//    private  void process(){
//        for(User user:users){
//            mailService.sendMail(user.getEmail(),"生日贺卡","<h1>祝"+user.getNickName()+"生日快乐</h1>",null,null);
//            log.info(user.getNickName() + "生日贺卡发送成功");
//        }
//    }

}