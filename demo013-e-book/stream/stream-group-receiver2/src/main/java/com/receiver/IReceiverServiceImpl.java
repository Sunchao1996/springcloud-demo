package com.receiver;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/9/5.
 */
@Service
@EnableBinding({IReceiverService.class})
public class IReceiverServiceImpl {
    @StreamListener(IReceiverService.INPUT)
    public void receiver(Product p) {
        System.out.println(p);
    }
}
