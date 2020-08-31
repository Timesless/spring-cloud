package com.yangzl.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author yangzl
 * @Date: 2020/8/30 21:02
 * @Desc: hystrix可作用在消费端，服务提供端。根据业务我们一般在消费端配置
 */

@Service
@DefaultProperties(defaultFallback = "handleMethod")
public class PaymentService {

    // 走默认的fallBack方法
    @HystrixCommand
    public String ok() {
        return Thread.currentThread().getName() + " ok";
    }

    // 走fallbackMethod指定的方法
    @HystrixCommand(fallbackMethod = "handleMethod")
    public String timeout() {
        int timeNum = 3;
        try { TimeUnit.SECONDS.sleep(timeNum); } catch(InterruptedException e) { e.printStackTrace(); }
        return Thread.currentThread().getName() + " timeout，耗时 :" + timeNum;
    }

    /**
     * 2020/8/30 服务调用失败，会跳转到该方法进行处理
     * 此时逻辑和错误处理，耦合度较高
     * @param
     * @return
     */
    public String handleMethod() {
        return "服务繁忙，请稍后再试";
    }
}
