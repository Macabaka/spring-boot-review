package com.soft1851.springboot.time.service;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.soft1851.springboot.time.model.Cron;
import org.hibernate.annotations.Cache;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:50
 * @Description:
 */
public interface CronService {

    @Cached(expire=3600,cacheType= CacheType.REMOTE)
    void updateCron(Cron cron);


    Cron findCronBtCronId(int cronId);
}
