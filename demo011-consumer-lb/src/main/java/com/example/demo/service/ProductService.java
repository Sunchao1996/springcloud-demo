package com.example.demo.service;

import com.example.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public List<Product> listProduct() {
        //拼接服务端地址
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/list");
        System.out.println(stringBuffer);
        //请求链接，获取数据
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Product>> parameterizedType = new ParameterizedTypeReference<List<Product>>() {};
        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(stringBuffer.toString(), HttpMethod.GET,null,parameterizedType);
        List<Product> productList = responseEntity.getBody();
        return productList;
    }

}
