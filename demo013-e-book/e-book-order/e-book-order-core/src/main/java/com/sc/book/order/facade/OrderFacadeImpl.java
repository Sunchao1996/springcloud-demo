package com.sc.book.order.facade;


import com.netflix.discovery.converters.Auto;
import com.sc.book.order.domain.Order;
import com.sc.book.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderService orderService;

    @Override
    public Integer insert(@RequestBody Order order) {
        return orderService.insert(order);
    }

    @Override
    public List<Order> findOrderByUserId(Integer userId) {
        return orderService.findOrderByUserId(userId);
    }

    @Override
    public void updateOrderByTrade(@RequestBody Order obj) {
        orderService.updateOrderByTrade(obj);
    }

    @Override
    public Order findOrderById(Integer id) {
        return orderService.findOrderById(id);
    }
}
