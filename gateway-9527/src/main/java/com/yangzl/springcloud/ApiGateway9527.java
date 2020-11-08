package com.yangzl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author yangzl
 * @Date: 2020/9/6 01:40
 * @Desc:
 *
 * Gateway如何执行：路由 断言 过滤
 */

@EnableEurekaClient
@SpringBootApplication
public class ApiGateway9527 {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateway9527.class, args);
    }
}
