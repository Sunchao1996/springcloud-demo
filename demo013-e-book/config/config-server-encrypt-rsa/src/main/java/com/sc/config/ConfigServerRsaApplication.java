package com.sc.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * what:
 *
 * @author 孙超 created on 2018/7/4
 */
@EnableEurekaClient
@SpringBootApplication
@EnableConfigServer
public class ConfigServerRsaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerRsaApplication.class, args);
    }
}
