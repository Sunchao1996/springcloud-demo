package com.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * what:  
 *
 * @author 孙超 created on 2018/4/4
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.TOPIC),
                key = "*.log.error"
        )
)
public class LogsReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("all---------------" + msg);
    }
}
