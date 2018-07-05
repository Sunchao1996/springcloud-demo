package com.sc.book.trade.facade;


import com.sc.book.order.domain.Order;
import com.sc.book.trade.domain.Trade;
import com.sc.book.trade.service.OrderService;
import com.sc.book.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class TradeFacadeImpl implements TradeFacade {
    @Autowired
    private OrderService orderService;

    @Autowired
    private TradeService tradeService;

    @Override
    public void createTrade(Order order) {

        //交易id
        Integer trade_id= tradeService.createTrade(order);
        order = orderService.findOrderById(order.getId());
        order.setTradeId(trade_id);
        order.setTradeStatus(true);

        orderService.updateOrderByTrade(order);

    }

}
