package com.eureka.service;

import com.eureka.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * what:  使用服务缓存
 *
 * @author 孙超 created on 2018/4/7
 */
@CacheConfig(cacheNames = {"com.sc.cache"})
@Service
public class ProductService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public List<Product> listProduct() {
        //拼接服务端地址
        ServiceInstance serviceInstance = loadBalancerClient.choose("e-book-product");
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/list");
        System.out.println(stringBuffer);
        //请求链接，获取数据
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Product>> parameterizedType = new ParameterizedTypeReference<List<Product>>() {
        };
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(stringBuffer.toString(), HttpMethod.GET, null, parameterizedType);
        List<Product> productList = responseEntity.getBody();
        return productList;
    }

    public List<Product> fallback() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(-1, "fallback"));
        return productList;
    }
    @Cacheable(key = "'product'+ #id")
    public Product get(Integer id){
        System.out.println("=================:"+id+"=============");
        return new Product(id,"tushu");
    }
    @CacheEvict(key="'product'+ #id")
    public void del(Integer id){
        System.out.println("=======del======:"+id+"=============");
    }
}
