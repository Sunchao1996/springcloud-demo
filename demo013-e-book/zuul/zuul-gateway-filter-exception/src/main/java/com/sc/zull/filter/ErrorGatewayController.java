package com.sc.zull.filter;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * what:    /error类,Spring Boot 1.x 默认采用ErrorController进行处理异常，如果要执行异常/error请求，需要实现ErrorController
 *
 * @author 孙超 created on 2018/7/14
 */
@RestController
public class ErrorGatewayController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error() {
        return "{\"result\":\"500 error!!!\"}";
    }
}
