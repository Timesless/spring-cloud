package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author yangzl
 * @Date: 2020/8/9 18:48
 * @Desc:
 */

@EnableEurekaClient
@SpringBootApplication
public class ServiceProvider8002 {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "8002");
        SpringApplication.run(ServiceProvider8002.class, args);
    }
}
