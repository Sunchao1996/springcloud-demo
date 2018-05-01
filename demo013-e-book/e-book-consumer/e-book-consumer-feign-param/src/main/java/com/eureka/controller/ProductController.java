package com.eureka.controller;

import com.book.product.domain.Product;
import com.eureka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> productList() {
        List<Product> list = productService.list();
        return list;
    }

    /*单个参数传递*/
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Product get(@RequestParam("id") Integer id) {
        Product product = productService.get(id);
        return product;
    }
    //复杂参数不能这么使用,接口中使用的是get请求
    @RequestMapping(value = "get1",method = RequestMethod.GET)
    public Product get1(Product product){
        return productService.get1(product);
    }
    //复杂参数使用方式1
    @RequestMapping(value = "get2",method = RequestMethod.GET)
    public Product get2(@RequestParam("id")Integer id,@RequestParam("name")String name){
        return productService.get2(id,name);
    }
    //复杂参数使用方法2，接口中使用的是post请求
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public Product add(Product product){
        return productService.add(product);
    }
}
