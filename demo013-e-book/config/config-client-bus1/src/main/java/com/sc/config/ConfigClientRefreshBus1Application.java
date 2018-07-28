package com.sc.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * what:
 *
 * @author 孙超 created on 2018/7/4
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientRefreshBus1Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientRefreshBus1Application.class, args);
    }
}
