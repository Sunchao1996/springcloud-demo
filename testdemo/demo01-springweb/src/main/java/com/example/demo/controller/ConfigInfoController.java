package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dtinsure on 2018/7/9.
 */
@Controller
public class ConfigInfoController {
    @Value("${boot.name}")
    private String name;

    @Value("${boot.location}")
    private String location;

    @Autowired
    private  ConfigInfoController2 configInfoController2;


    @RequestMapping("/boot/config2")
    public  @ResponseBody String config(){
        return  configInfoController2.getName()+"**"+configInfoController2.getLocation();
    }
}
