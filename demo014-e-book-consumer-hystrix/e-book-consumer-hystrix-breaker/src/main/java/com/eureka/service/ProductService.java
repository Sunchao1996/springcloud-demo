package com.eureka.service;

import com.eureka.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
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
 * what:   服务熔断
 *
 * @author 孙超 created on 2018/4/7
 */
@Service
public class ProductService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
//            默认20个；10秒内请求数大于20个的时候就启动熔断器，当请求符合熔断条件的时候就调用getFallback();
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "1"),
//            请求错误率达到50%时就熔断，然后for循环发起请求，当请求符合熔断条件时将触发getFallback();
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "50"),
//            默认5秒，熔断多少秒后回去重试
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000")
    })
    public List<Product> listProduct() {
        throw new RuntimeException();
//        //拼接服务端地址
//        ServiceInstance serviceInstance = loadBalancerClient.choose("e-book-product");
//        StringBuffer stringBuffer = new StringBuffer("");
//        stringBuffer.append("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/list");
//        System.out.println(stringBuffer);
//        //请求链接，获取数据
//        RestTemplate restTemplate = new RestTemplate();
//        ParameterizedTypeReference<List<Product>> parameterizedType = new ParameterizedTypeReference<List<Product>>() {
//        };
//        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(stringBuffer.toString(), HttpMethod.GET, null, parameterizedType);
//        List<Product> productList = responseEntity.getBody();
//        return productList;
    }

    public List<Product> fallback() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(-1, "fallback"));
        return productList;
    }

}
