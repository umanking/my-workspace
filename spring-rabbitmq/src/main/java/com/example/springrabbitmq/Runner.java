package com.example.springrabbitmq;


import com.example.springrabbitmq.message.CustomMessage;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Runner implements ApplicationRunner {

    private static final String topicExchange = "topic-message";
    private static String routingKey = "foo.bar.baz";

    private final RabbitTemplate rabbitTemplate;
    private final BatchingRabbitTemplate batchingRabbitTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("send message.....");
        IntStream.range(0, 5)
            .forEach(i -> {
                CustomMessage message = new CustomMessage();
                message.setText("hello message : " + i);
                log.info("send message :{}", message);
                rabbitTemplate.convertAndSend(topicExchange, routingKey, message);
            });

//        List<CustomMessage> list = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            CustomMessage customMessage = new CustomMessage();
//            customMessage.setText("hello message" + i);
////            customMessage.setPriority(1);
////            customMessage.setSecret(true);
//            list.add(customMessage);
//
//            log.info("send messages : {} ", list);
//            rabbitTemplate.convertAndSend(topicExchange, routingKey, customMessage);
//        }

//        batchingRabbitTemplate.convertAndSend(topicExchange, routingKey, list);
//        batchingRabbitTemplate.flush();

        // convert object to message(AMQP)
//        rabbitTemplate.convertAndSend(topicExchange, "foo.bar.baz", customMessage);

    }
}
