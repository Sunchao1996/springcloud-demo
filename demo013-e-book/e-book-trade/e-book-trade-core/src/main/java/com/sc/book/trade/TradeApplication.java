package com.sc.book.trade;

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
@MapperScan("com.sc.book.trade.persistence")
public class TradeApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeApplication.class, args);
    }
}
