package com.eureka.controller;

import com.eureka.domain.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class ProductController {
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Product> list(){
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"第一本书"));
        list.add(new Product(2,"第二本书"));
        list.add(new Product(3,"第三本书"));
        return list;
    }

}
