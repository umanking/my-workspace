package com.example.springrabbitmq.listener;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserListener {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @RabbitListener(queues = "message-queue")
    public void receiveMessage(Message message) {
        log.info("receive message :{}", message);
    }



//    @RabbitListener(queues = "spring-boot", containerFactory = "consumerBathFactory")
    public void batch1(List<Message> messageList) {

        for (Message message : messageList) {
            System.out.println("message : "+ message);
        }

    }
}
