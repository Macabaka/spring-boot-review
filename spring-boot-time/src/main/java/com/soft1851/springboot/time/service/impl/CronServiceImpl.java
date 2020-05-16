package com.soft1851.springboot.time.service.impl;

import com.soft1851.springboot.time.model.Cron;
import com.soft1851.springboot.time.repository.CronRepository;
import com.soft1851.springboot.time.service.CronService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:50
 * @Description:
 */
@Service
public class CronServiceImpl implements CronService {

    @Resource
    private CronRepository cronRepository;

    @Override
    public void updateCron(Cron cron) {
        cronRepository.updateCron(cron.getCronId(), cron.getCron(), cron.getCronName());
    }

    @Override
    public Cron findCronBtCronId(int cronId) {
        return cronRepository.findCronByCronId(cronId);
    }
}
