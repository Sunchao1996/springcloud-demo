package com.eureka.controller;

import com.eureka.domain.Product;
import com.eureka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "getProduct",method =  RequestMethod.GET)
    public void getProduct() throws ExecutionException, InterruptedException {
        Future<Product> p1 = productService.listProduct(1);
        Future<Product> p2 = productService.listProduct(2);
        Future<Product> p3 = productService.listProduct(3 );
        System.out.println(p1.get().toString());
        System.out.println(p2.get().toString());
        System.out.println(p3.get().toString());

    }
}
