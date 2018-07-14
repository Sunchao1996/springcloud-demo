package com.sc.zull;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * what:
 *
 * @author 孙超 created on 2018/7/4
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulTimeoutApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulTimeoutApplication.class, args);
    }
}
