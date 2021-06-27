package com.example.springrabbitmq.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomMessageListener {

//    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(final Message message) {
        log.info("receive message:{}", message);
    }
}
