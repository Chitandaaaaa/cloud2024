package com.lixiameng.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.util.retry.Retry;

/**
 * @program: cloud2024
 * @description:
 * @author: lixiameng
 * @create: 2024-03-04 22:11
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer(){
        return Retryer.NEVER_RETRY; // 默认配置是不走充实策略的

        // 最大请求测试为3（1+2），初始时间间隔时100ms，崇事件最大间隔时间1s。
//        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
