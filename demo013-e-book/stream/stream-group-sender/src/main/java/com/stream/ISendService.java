package com.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2018/9/5.
 */
public interface ISendService {
    String OUTPUT="outputProduct";
    @Output(ISendService.OUTPUT)
    SubscribableChannel send();
}
