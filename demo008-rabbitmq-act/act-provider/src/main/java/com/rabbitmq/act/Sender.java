package com.rabbitmq.act;

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
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send() {
        String msg = "hello " + new Date();
        //指定交换器、路由键
        amqpTemplate.convertAndSend(exchange, "log.error.routing.key", msg);
    }

}
