package com.yangzl.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author yangzl
 * @Date: 2020/8/30 21:02
 * @Desc: hystrix可作用在消费端，服务提供端。根据业务我们一般在消费端配置
 * 超时 / 异常 都进入Hystrix服务降级
 */

@Service
@DefaultProperties(defaultFallback = "defaultHandleMethod")
public class PaymentService {

    // 走默认的fallBack方法
    @HystrixCommand
    public String ok() {
        // int exp = 10 / 0;
        return Thread.currentThread().getName() + " ok";
    }

    // 业务失败会调用fallbackMethod指定的方法
    @HystrixCommand(fallbackMethod = "handleMethod", commandProperties = {
            // 该线程超时时间2s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
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
    public String defaultHandleMethod() {
        return "默认处理方法：服务繁忙，请稍后再试";
    }
    public String handleMethod() {
        return "指定处理方法：服务繁忙，请稍后再试";
    }
}
