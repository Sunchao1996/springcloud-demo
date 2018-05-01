package com.eureka.service;

import com.book.product.domain.Product;
import com.book.product.facade.ProductFacade;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 孙超 created on 2018/4/7
 */
@FeignClient(name="e-book-product")
public interface ProductService extends ProductFacade {

}
