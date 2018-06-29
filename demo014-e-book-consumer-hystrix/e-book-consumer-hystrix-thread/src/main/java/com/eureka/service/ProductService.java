package com.eureka.service;

import com.eureka.domain.HttpClientUtil;
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
 * what:    线程池隔离
 * @author 孙超 created on 2018/4/7
 */
@Service
public class ProductService {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(groupKey = "e-book-product", commandKey = "listProduct", threadPoolKey = "e-book-product",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),//线程池大小
                    @HystrixProperty(name = "maxQueueSize", value = "2000"),//最大队列长度
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1"),//线程存活时间
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "1500")//拒绝请求数量最大值
            }, fallbackMethod = "fallback"
    )
    public List<Product> listProduct() {
        //拼接服务端地址
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
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "list"));
        return productList;
    }

    public List<Product> fallback() {
        System.out.println("fallback");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(-1, "fallback"));
        return productList;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i =0 ;i<1000;i++) {
            Thread t = new Thread(new ThreadRun());
            t.start();
        }
        Thread.sleep(10000);
    }

}

class ThreadRun implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("==========="+HttpClientUtil.doGet("http://localhost:9000/list"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
