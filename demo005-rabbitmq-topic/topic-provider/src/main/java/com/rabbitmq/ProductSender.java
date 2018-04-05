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
public class ProductSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() {
        amqpTemplate.convertAndSend(exchange, "product.log.info", "product.log.info");
        amqpTemplate.convertAndSend(exchange, "product.log.error", "product.log.error");
        amqpTemplate.convertAndSend(exchange, "product.log.warn", "product.log.warn");
        amqpTemplate.convertAndSend(exchange, "product.log.debug", "product.log.debug");
    }

}
