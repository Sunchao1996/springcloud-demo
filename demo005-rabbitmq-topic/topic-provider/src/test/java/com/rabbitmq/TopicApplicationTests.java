package com.rabbitmq;

import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicApplicationTests {
    @Autowired
    private UserSender userSender;
    @Autowired
    private ProductSender productSender;
    @Autowired
    private OrderSender ordeSender;

    @Test
    public void send() {
        userSender.send();
        productSender.send();
        ordeSender.send();
    }

}
