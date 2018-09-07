package com.rabbitmq;

import com.stream.ISendService;
import com.stream.Product;
import com.stream.StreamSenderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamSenderApplication.class)
public class StreamSenderApplicationTests {
    @Autowired
    private ISendService iSendService;

    @Test
    public void sendTest() {
        Product obj=new Product();
        obj.setId(100);
        obj.setName("spring cloud");
        for (int i = 0; i <10; i++) {
            Message message=MessageBuilder.withPayload(obj).build();
            iSendService.send().send(message);
        }
    }
}
