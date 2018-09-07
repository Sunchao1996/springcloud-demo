package com.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding({IReceiverService.class})
public class StreamReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamReceiverApplication.class, args);
    }
}
