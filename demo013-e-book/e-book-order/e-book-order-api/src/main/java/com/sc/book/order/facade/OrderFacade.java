package com.sc.book.order.facade;

import com.sc.book.order.domain.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * what:接口里面的方法体怎么写，实现类和使用的时候就怎么写
 *
 * @author 孙超 created on 2018/4/7
 */
@RequestMapping("/order")
public interface OrderFacade {
    /**
     * 添加一个订单
     */
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Integer insert(@RequestBody Order order);

    /**
     * 根据用户id获取订单
     */
    @RequestMapping(value = "/findOrderByUserId", method = RequestMethod.GET)
    List<Order> findOrderByUserId(@RequestParam("userId") Integer userId);

    /**
     * 根据交易号更新
     */
    @RequestMapping(value = "/updateOrderByTrade", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrderByTrade(@RequestBody Order obj);

    /**
     * 根据订单id获取
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findOrderById", method = RequestMethod.GET)
    public Order findOrderById(@RequestParam("id") Integer id);
}
