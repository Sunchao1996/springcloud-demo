package com.rabbitmq.durable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
public class ProviderApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    public void send() throws InterruptedException {
        for (int i = 1; i <= 200; i++) {
            Thread.sleep(1000);
            sender.send(i);
        }
    }

}
