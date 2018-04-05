package com.rabbitmq.durable;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 孙超 created on 2018/4/4
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(int n) {
        amqpTemplate.convertAndSend(exchange, "log.error.routing.key", n);
        System.out.println("send:" + n);
    }
}
