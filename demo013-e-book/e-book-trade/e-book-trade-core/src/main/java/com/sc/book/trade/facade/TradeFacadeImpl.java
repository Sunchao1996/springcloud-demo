package com.sc.book.trade.facade;


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
    public Integer createTrade(Thread thread) {
        return null;
    }
}
