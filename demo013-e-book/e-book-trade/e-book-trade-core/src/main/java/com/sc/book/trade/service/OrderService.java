package com.sc.book.trade.service;

import com.sc.book.order.facade.OrderFacade;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * what:   orderService
 *
 * @author 孙超 created on 2018/7/5
 */
@FeignClient("e-book-order")
public interface OrderService extends OrderFacade {

}
