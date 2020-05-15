package com.soft1851.springboot.time.repository;

import com.soft1851.springboot.time.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Johnny
 * @Date: 2020/5/15 20:14
 * @Description:
 */
public interface CronRepository extends JpaRepository<Cron,Integer> {

    Cron findCronByCronId(int cronId);

    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update cron set cron= ?2 ,cron_name = ?3 where  cron_id = ?1",nativeQuery = true)
    int updateCron(int id, String cron, String cron_name);

}
