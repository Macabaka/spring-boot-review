package com.soft1851.springboot.configuration.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Johnny
 * @Date: 2020/5/12 17:15
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "music")
public class Music {

    private String name;

    private String artist;

    private Integer playCount;

    private  String description;

    private List<String > comments;

    private Map<String,Integer> rank;
}
