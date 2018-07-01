package com.eureka.hystrix;

import com.book.product.domain.Product;
import com.eureka.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * what:   feign服务降级，降级类，记录错误日志
 *
 * @author 孙超 created on 2018/6/30
 */
@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
    private Logger logger = LoggerFactory.getLogger(ProductServiceFallbackFactory.class);

    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public List<Product> list() {
                logger.warn("fallback exception", throwable);
                List<Product> list = new ArrayList<>();
                list.add(new Product(-1, "fallback"));
                return list;
            }
        };
    }
}
