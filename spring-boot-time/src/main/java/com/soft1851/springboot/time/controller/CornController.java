package com.soft1851.springboot.time.controller;

import com.soft1851.springboot.time.model.Cron;
import com.soft1851.springboot.time.repository.CronRepository;
import com.soft1851.springboot.time.service.CronService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping()
    public void updateCorn(@RequestBody Cron cron) {
        //log.info(cron.toString());
        cronService.updateCron(cron);
    }
}
