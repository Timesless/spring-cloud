package com.yangzl.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yangzl
 * @Date: 2020/8/23 13:17
 * @Desc: 自定义负载均衡算法
 */

@Slf4j
public class MyRibbonRule extends AbstractLoadBalancerRule {

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer loadBalancer, Object key) {

        // 无可用的负载均衡算法
        if (loadBalancer == null) {
            log.warn("无可用负载算法");
            return null;
        }

        int count = 0;
        Server server = null;

        // retry 10 times
        while (server == null && count ++ < 10) {
            List<Server> alives = loadBalancer.getReachableServers();
            List<Server> all = loadBalancer.getAllServers();
            int upCount = alives.size(), allCount = all.size();

            if (upCount == 0 || allCount == 0) {
                log.warn("no up server available");
                return null;
            }
            int next = getAndIncrement();
            server = all.get(next % allCount);

            // 始终访问第一台服务器，测试是否启用自定义规则
            // server = all.get(0);

            if (null == server) {
                Thread.yield();
                continue;
            }
            if (server.isAlive() && server.isReadyToServe()) {
                return server;
            }

            // next tick
            server = null;
        }

        if (count >= 10) {
            log.warn("No available alive server after retry 10 time");
        }
        return server;
    }


    private final int getAndIncrement() {
        int curr, next;
        for (;;) {
            curr = atomicInteger.get();
            next = curr == 0xffffffff ? 0 : curr + 1;
            if (atomicInteger.compareAndSet(curr, next)) {
                return next;
            }
        }
    }
}
