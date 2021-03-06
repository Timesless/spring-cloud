package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author yangzl
 * @Date: 2020/8/9 18:47
 * @Desc:
 */

@EnableEurekaClient
@SpringBootApplication
public class ServiceProvider8001 {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "8001");
        SpringApplication.run(ServiceProvider8001.class, args);
    }
}
