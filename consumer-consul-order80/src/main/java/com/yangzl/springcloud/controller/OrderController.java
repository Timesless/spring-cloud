package com.yangzl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author yangzl
 * @Date: 2020/8/23 12:39
 * @Desc:
 */

@Slf4j
@RestController
@RequestMapping("consumer")
public class OrderController {

    public static final String INVOKE_URL = "http://payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consul")
    public String getConsulService() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }

}
