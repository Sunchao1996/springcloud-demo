package com.sc.book.service;

import com.sc.book.trade.facade.TradeFacade;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2018/7/5.
 */
@FeignClient("e-book-trade")
public interface TradeService extends TradeFacade{
}
