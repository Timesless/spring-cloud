package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangzl
 * @date 2020/9/12 16:36
 * @desc
 */

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfig3377 {

    public static void main(String[] args) {
        // System.setProperty("spring.profiles.active", "3377");
        SpringApplication.run(NacosConfig3377.class, args);
    }
}
