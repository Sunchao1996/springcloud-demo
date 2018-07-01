package com.eureka.service;

import com.book.product.domain.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * what:  feign的服务降级，记录错误日志
 *
 * @author 孙超 created on 2018/4/7
 */
@FeignClient(name="e-book-product",fallbackFactory = com.eureka.hystrix.ProductServiceFallbackFactory.class)
public interface ProductService  {
    @RequestMapping(value = "product/list",method = RequestMethod.GET)
    List<Product> list();
}
