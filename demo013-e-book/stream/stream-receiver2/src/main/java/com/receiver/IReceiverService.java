package com.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2018/9/5.
 */
public interface IReceiverService {
    @Input("sc-exchange")
    SubscribableChannel receiver();
}
