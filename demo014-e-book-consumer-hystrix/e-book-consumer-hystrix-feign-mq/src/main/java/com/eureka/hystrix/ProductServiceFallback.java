package com.eureka.hystrix;

import com.book.product.domain.Product;
import com.eureka.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * what:   feign服务降级，降级方法
 *
 * @author 孙超 created on 2018/6/30
 */
@Component
public class ProductServiceFallback implements ProductService {
    @Override
    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(-1, "fallback"));
        return list;
    }
}
