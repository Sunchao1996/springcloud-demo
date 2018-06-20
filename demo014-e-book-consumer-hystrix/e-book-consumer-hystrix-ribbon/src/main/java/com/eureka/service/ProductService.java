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
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 孙超 created on 2018/4/7
 */
@Service
public class ProductService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
//            默认10秒，如果10秒之内并发数达到该设置值，请求会被拒绝和抛出异常并且fallback不会被调用
            @HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "15")
    })
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

}
