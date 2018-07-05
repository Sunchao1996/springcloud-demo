package com.sc.book.service;

import com.book.product.facade.ProductFacade;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2018/7/5.
 */
@FeignClient("e-book-product")
public interface ProductService extends ProductFacade{
}
