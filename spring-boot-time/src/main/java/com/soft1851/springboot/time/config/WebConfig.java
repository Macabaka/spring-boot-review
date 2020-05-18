package com.soft1851.springboot.time.config;

import com.soft1851.springboot.time.filter.TrustedEndpointsFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Johnny
 * @Date: 2020/5/18 09:43
 * @Description:
 */
@Configuration
public class WebConfig {
    // 内部端口
    @Value("${server.trustedPort:8088}")
    private String trustedPort;

    // 内部接口 URL 路径前缀
    @Value("${server.trustedPathPrefix:/internal/}")
    private String trustedPathPrefix;

    @Bean
    public FilterRegistrationBean<TrustedEndpointsFilter> trustedEndpointsFilter() {
        return new FilterRegistrationBean<>(new TrustedEndpointsFilter(trustedPort, trustedPathPrefix));
    }
}
