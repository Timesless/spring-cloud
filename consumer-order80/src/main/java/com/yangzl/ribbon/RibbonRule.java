package com.yangzl.ribbon;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yangzl
 * @Date: 2020/8/23 13:03
 * @Desc: 使用自定义的RibbonRule
 */

@Configuration
public class RibbonRule {

    @Bean
    public IRule myRibbonRule() {
        /**
         * new RoundRobinRule();
         * new RetryRule();
         * new RandomRule()
         */
        return new MyRibbonRule();
    }

}
