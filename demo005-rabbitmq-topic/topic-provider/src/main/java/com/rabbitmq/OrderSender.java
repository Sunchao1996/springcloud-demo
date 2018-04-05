package com.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * what:    发送消息
 *
 * @author 孙超 created on 2018/4/4
 */
@Component
public class OrderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() {
        //指定交换器、路由键
        amqpTemplate.convertAndSend(exchange, "order.log.info", "order.log.info");
        amqpTemplate.convertAndSend(exchange, "order.log.error", "order.log.error");
        amqpTemplate.convertAndSend(exchange, "order.log.warn", "order.log.warn");
        amqpTemplate.convertAndSend(exchange, "order.log.debug", "order.log.debug");
    }

}
