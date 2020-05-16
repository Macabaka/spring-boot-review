package com.soft1851.springboot.time.controller;

import com.soft1851.springboot.time.model.Cron;
import com.soft1851.springboot.time.model.User;
import com.soft1851.springboot.time.repository.CronRepository;
import com.soft1851.springboot.time.service.CronService;
import com.soft1851.springboot.time.service.MailService;
import com.soft1851.springboot.time.service.UserService;
import com.soft1851.springboot.time.util.ApplicationContextProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:47
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/corn")
@Slf4j
public class CornController {

    @Resource
    private CronService cronService;

    @Resource
    private  UserService userService;

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    ScheduledFuture<?> future;

    public   static  class MyRunnable implements  Runnable{
        @Resource
        private  UserService userService= ApplicationContextProvider.getBean(UserService.class);

        @Resource
        private MailService mailService = ApplicationContextProvider.getBean(MailService.class);

        @Override
        public void run() {
            List<User> userList = userService.findAll();
            for (User user : userList) {
                mailService.sendMail(user.getEmail(),"生日贺卡","<h1>祝"+user.getNickName()+"生日快乐</h1>",null,null);
                log.info(user.getNickName() + "生日贺卡发送成功");
            }
            log.info("我的定时任务："+ LocalDateTime.now());
        }
    }

    @PostMapping()
    public String  updateCorn(@RequestBody Cron cron) {
        stopCron();
        cronService.updateCron(cron);
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger(cron.getCron()));
        return  "修改定时任务";
    }

    @GetMapping("/start")
    public String start(@RequestParam("id")int id) {
        String cron = cronService.findCronBtCronId(id).getCron();
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger(cron));
        log.info("定时任务启动");
        return "定时任务启动";
    }

    @GetMapping("/stop")
    public String stopCron() {
        if (future != null) {
            future.cancel(true);
        }
        log.info("定时任务停止");
        return "定时任务停止";
    }

}
