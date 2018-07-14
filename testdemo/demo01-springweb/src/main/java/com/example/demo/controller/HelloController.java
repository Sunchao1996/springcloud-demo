package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dtinsure on 2018/7/9.
 */
@Controller
public class HelloController {

    @RequestMapping("/boot/hello")
    public @ResponseBody String hello(){
        //@ResponseBody注解 返回字符串时直接就是字符串，返回对象时会转换成json
        return  "Hello SpringBoot!";
    }
}
