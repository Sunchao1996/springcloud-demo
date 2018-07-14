package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dtinsure on 2018/7/9.
 */

@RestController
public class MVCController {

    //以下两个方法只支持GET请求，其他请求会出现405 请求不支持

    @RequestMapping(value = "/boot/getUser",method = RequestMethod.GET)
    public Object getUser(){
        User user=new User();
        user.setId(100);
        user.setName("张三");
        return  user;
    }

    @GetMapping("/boot/getUser2")
    public Object getUser2(){
        User user=new User();
        user.setId(1000);
        user.setName("张三2");
        return  user;
    }
}
