package com.yangzl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author yangzl
 * @Date: 2020/8/22 22:39
 * @Desc:
 */

@Slf4j
@RestController
@RequestMapping("consumer")
public class OrderController {

    private static final String INVOKE_URL = "http://payment-provider";

    @Value("${server.port}")
    private String port;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("zk")
    public String getZk() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
