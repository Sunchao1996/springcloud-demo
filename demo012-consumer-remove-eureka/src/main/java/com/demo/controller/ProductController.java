package com.demo.controller;



import com.demo.domain.Product;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "list",method =  RequestMethod.GET)
    public List<Product> productList(){
        List<Product> list = productService.listProduct();
        return list;
    }
}
