package com.yangzl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzl
 * @date 2020/9/12 13:45
 * @desc
 */

@Slf4j
@RestController
@RequestMapping("payment")
public class NacosPaymentController {

    @Value("${server.port}")
    private String port;


    @GetMapping("nacos")
    public String nacosServer() {
        return "from nacos server: " + port;
    }


}
