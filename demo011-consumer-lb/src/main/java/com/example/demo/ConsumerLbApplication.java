package com.example.demo;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerLbApplication {
//     设置负载均衡策略
//    @Bean
//    public IRule ribbonRule() {
//        return new RandomRule();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerLbApplication.class, args);
    }
}
