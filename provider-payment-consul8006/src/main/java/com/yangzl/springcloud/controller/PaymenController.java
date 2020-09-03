package com.yangzl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yangzl
 * @Date: 2020/8/22 23:02
 * @Desc:
 */

@Slf4j
@RestController
@RequestMapping("payment")
public class PaymenController {

    @Value("${server.port}")
    private String port;

    @GetMapping("consul")
    public String consulService() {
        return "springcloud with consul in " + port;
    }
}
