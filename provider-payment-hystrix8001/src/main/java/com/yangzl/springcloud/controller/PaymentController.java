package com.yangzl.springcloud.controller;

import com.yangzl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author yangzl
 * @Date: 2020/8/30 21:01
 * @Desc:
 */

@RestController
@RequestMapping("hystrix")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("ok")
    public String ok() {
        return paymentService.ok();
    }

    @GetMapping("timeout")
    public String timeout() {
        return paymentService.timeout();
    }

}
