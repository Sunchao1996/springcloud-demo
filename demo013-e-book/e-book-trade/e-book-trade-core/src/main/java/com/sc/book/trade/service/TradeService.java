package com.sc.book.trade.service;


import com.sc.book.order.domain.Order;
import com.sc.book.trade.domain.Trade;
import com.sc.book.trade.persistence.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * what:  交易service
 *
 * @author 孙超 created on 2018/7/4
 */
@Service
public class TradeService {
    @Autowired
    private TradeMapper tradeMapper;

    /**
     * 创建交易订单
     */
    public Integer createTrade(Order order) {
        Trade trade = new Trade();
        trade.setPayStatus((byte)4);
        trade.setPayType((byte)1);
        trade.setOrderId(order.getId());
        trade.setUserId(order.getUserId());
        trade.setGatewayPayPrice(order.getPrice());
        trade.setGatewayPayTime(new Date());
        //网管流水号
        trade.setGatewayPayNum(String.valueOf(new Date().getTime()));
        return tradeMapper.insert(trade);
    }
}
