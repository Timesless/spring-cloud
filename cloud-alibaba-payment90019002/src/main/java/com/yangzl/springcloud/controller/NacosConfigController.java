package com.yangzl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzl
 * @date 2020/9/12 16:41
 * @desc 当环境变量为dev时,触发此controller注入为bean
 */

@Slf4j
@Profile("3377")
// 配置自动更新
@RefreshScope
@RestController
@RequestMapping("config")
public class NacosConfigController {

    @Value("${infos}")
    private String configInfo;

    /**
     * 2020/9/12 测试nacos作为配置中心
     * @param
     * @return
     */
    @GetMapping("nacos")
    private String nacosConfig() {
        return "config from nacos: " + configInfo;
    }
}
