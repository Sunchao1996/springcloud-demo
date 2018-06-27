package com.eureka.service;

import com.eureka.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * what:   请求合并
 *
 * @author 孙超 created on 2018/4/7
 */
@Service
public class ProductService {
    /*请求合并的语法，返回值Future，GLOBAL表示一个请求内的多次服务请求进行合并*/
    @HystrixCollapser(batchMethod = "batchProduct", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {
//           时间间隔在20ms之内的请求会被合并成为一个请求
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
//                    设置触发批处理执行之前，批处理中允许执行的最大请求数
                    @HystrixProperty(name = "maxRequestsInBatch", value = "200"),
            })
//    请求的参数必须是一个，如果需要接受多个参数需要使用类来接受
    public Future<Product> listProduct(Integer id) {
        System.out.println("======" + id + "====");
        return null;
    }

    @HystrixCommand
    public List<Product> batchProduct(List<Integer> ids) {
        for (Integer id : ids) {
            System.out.println(id);
        }
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "111"));
        list.add(new Product(2, "222"));
        list.add(new Product(3, "113"));
        return list;
    }
}
