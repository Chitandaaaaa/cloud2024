package com.lixiameng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // consul服务注册
public class Main80 {

    public static void main(String[] args) {
        SpringApplication.run(Main80.class, args);
    }
}