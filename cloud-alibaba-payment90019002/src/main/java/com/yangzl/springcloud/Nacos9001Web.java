package com.yangzl.springcloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author yangzl
 * @date 2020/9/12 12:52
 * @desc 作为web项目启动, 将build.gradle 配置打包为war
 *          apply plugin: 'war'
 */
public class Nacos9001Web extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NacosPayment9001.class);
    }
}




