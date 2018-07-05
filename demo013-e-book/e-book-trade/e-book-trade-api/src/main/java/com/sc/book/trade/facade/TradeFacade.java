package com.sc.book.trade.facade;


import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * what:接口里面的方法体怎么写，实现类和使用的时候就怎么写
 *
 * @author 孙超 created on 2018/4/7
 */
@RequestMapping("/trade")
public interface TradeFacade {
    @RequestMapping(value = "createTrade", method = RequestMethod.POST)
    Integer createTrade(@RequestBody Thread thread);
}
