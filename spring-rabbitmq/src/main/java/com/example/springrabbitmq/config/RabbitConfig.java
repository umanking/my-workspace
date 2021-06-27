package com.example.springrabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Slf4j
@Configuration
public class RabbitConfig {

    private static final String queueName = "message-queue";
    private static final String topicExchangeName = "topic-message";

    // 큐를 만든다.
    // exchange 는 라우팅을 한다.topicExchange를 통해서
    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }


    // spring boot가 connectionFactory, rabbitTemplate 는 기본으로 등록해줌
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    BatchingRabbitTemplate batchingRabbitTemplate(ConnectionFactory connectionFactory) {
        BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(50, 1024, 1000);
        TaskScheduler scheduler = new ConcurrentTaskScheduler();

        BatchingRabbitTemplate batchingRabbitTemplate = new BatchingRabbitTemplate(batchingStrategy,
            scheduler);
        batchingRabbitTemplate.setConnectionFactory(connectionFactory);
//        batchingRabbitTemplate.setMessageConverter(messageConverter());

        log.info("connectionFactory :{}", connectionFactory);

        return batchingRabbitTemplate;
    }

    @Bean
    SimpleRabbitListenerContainerFactory consumerBathFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setBatchListener(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

/*
    @Bean
    SimpleMessageListenerContainer simpleMessageListenerContainer(
            SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory){
        simpleRabbitListenerContainerFactory.setConnectionFactory();
    }
*/


}
