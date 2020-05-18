package com.soft1851.springboot.quartz.entity.dto;

import lombok.Data;

/**
 * @author Johnny
 * @Date: 2020/5/19 00:10
 * @Description:
 */
@Data
public class ModifyCronDto {
    /**
     * 作业的id
     */
    private Integer id;

    /**
     * 作业的cron表达式
     */
    private String cron;
}
