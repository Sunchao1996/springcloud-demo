package com.sc.book.service;

import com.sc.book.order.facade.OrderFacade;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2018/7/5.
 */
@FeignClient("e-book-order")
public interface OrderService extends OrderFacade{
}
