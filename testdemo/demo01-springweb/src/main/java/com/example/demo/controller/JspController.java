package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Dtinsure on 2018/7/9.
 */

@Controller
public class JspController {
    @GetMapping("/boot/index")
    public String index(Model model){
        model.addAttribute("a","a");
        model.addAttribute("msg","springBoot集成jsp");
        return "index";
    }
}
