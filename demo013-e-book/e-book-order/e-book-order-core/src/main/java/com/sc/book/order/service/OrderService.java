package com.sc.book.order.service;

import com.sc.book.order.domain.Order;
import com.sc.book.order.persistence.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * what:   商品service
 *
 * @author 孙超 created on 2018/7/4
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public int insert(Order order) {
        orderMapper.insert(order);
        return order.getId();
    }

    public List<Order> findOrderByUserId(Integer userId) {

        return orderMapper.findOrderByUserId(userId);
    }

    public void updateOrderByTrade(Order obj) {
        orderMapper.updateByPrimaryKey(obj);
    }

    public Order findOrderById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }
}
