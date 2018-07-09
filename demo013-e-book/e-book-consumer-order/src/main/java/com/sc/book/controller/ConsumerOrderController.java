package com.sc.book.controller;

import com.sc.book.order.domain.Order;
import com.sc.book.product.domain.Product;
import com.sc.book.service.OrderService;
import com.sc.book.service.ProductService;
import com.sc.book.service.TradeService;
import com.sc.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@RestController
@RequestMapping("/consumerorder")
public class ConsumerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private TradeService tradeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public List<Order> createOrder(String userName, String password) {
        //先登录
        Integer userId = userService.login(userName, password);
        //获取第一个商品
        List<Product> productList = productService.findAllProduct();
        Product product = productList.get(0);
        System.out.println(product);
        //生成订单
        Order order = new Order();
        order.setPrice(product.getPrice());
        order.setProductId(product.getId());
        order.setTradeStatus(false);
        order.setCreateTime(new Date());
        order.setUserId(userId);
        order.setDeleted((byte)1);
        System.out.println("=====order" + order);
        Integer order_id = orderService.insert(order);
        order.setId(order_id);
        //开始交易
        tradeService.createTrade(order);
        List<Order> lists = orderService.findOrderByUserId(userId);
        return lists;
    }

}
