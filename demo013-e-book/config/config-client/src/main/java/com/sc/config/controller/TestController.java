package com.sc.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * what:    测试配置中心
 *
 * @author 孙超 created on 2018/7/16
 */
@RestController
public class TestController {
    @Value("${book.config}")
    private String msg;

    @RequestMapping("/test")
    public String test() {
        return this.msg;
    }
}
