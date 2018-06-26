package com.eureka.controller;

import com.eureka.domain.Product;
import com.eureka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
    @RequestMapping(value = "get",method =  RequestMethod.GET)
    public Product get(Integer id){
        return productService.get(id);
    }
    @RequestMapping(value = "del",method =  RequestMethod.GET)
    public void del(Integer id){
        productService.del(id);
    }
}
