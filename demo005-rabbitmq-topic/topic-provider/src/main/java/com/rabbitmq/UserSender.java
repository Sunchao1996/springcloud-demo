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
public class UserSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() {
        amqpTemplate.convertAndSend(exchange, "user.log.info", "user.log.info");
        amqpTemplate.convertAndSend(exchange, "user.log.error", "user.log.error");
        amqpTemplate.convertAndSend(exchange, "user.log.warn", "user.log.warn");
        amqpTemplate.convertAndSend(exchange, "user.log.debug", "user.log.debug");
    }

}
