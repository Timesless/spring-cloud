package com.yangzl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author yangzl
 * @Date: 2020/8/23 12:39
 * @Desc:
 */
@Configuration
public class BeanConfig {

    /**
     * 2020/8/23 使用自定义的RibbonRule，注释掉@LoadBalanced
     * @param
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
