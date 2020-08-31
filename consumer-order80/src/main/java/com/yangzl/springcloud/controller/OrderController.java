package com.yangzl.springcloud.controller;

import com.yangzl.springcloud.entities.CommonResult;
import com.yangzl.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author yangzl
 * @Date: 2020/8/8 16:14
 * @Desc:
 */

@Slf4j
@RestController
@RequestMapping("consumer/payment")
public class OrderController {

    /**
     * 服务提供方的地址
     * 当集群时，只需要注册到eureka服务名称，需要配合RestTemplate LoadBalance
     */
    private static final String SAVE_URL = "http://PAYMENT-PROVIDER/payment/save";
    private static final String QUERY_URL = "http://PAYMENT-PROVIDER/payment/get/";

    @Resource
    private RestTemplate restTemplate;


    @PostMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult savePayment(Payment payment) {
        return restTemplate.postForObject(SAVE_URL, payment, CommonResult.class);
    }

    @GetMapping(value = "get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult queryPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(QUERY_URL + id, CommonResult.class);
    }


}
