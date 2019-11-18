package com.chnsys.cn.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class: TestConfiguration
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-07-02 10:04
 */

@Configuration
//下面的注解放到了启动类上
//@RibbonClient(name = "microservice-provider-user",configuration = TestConfiguration.class)
public class TestConfiguration {
    @Autowired
    IClientConfig config;


    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }


}
