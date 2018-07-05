package com.sc.book.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * what:
 *
 * @author 孙超 created on 2018/7/4
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.sc.book.order.persistence")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
