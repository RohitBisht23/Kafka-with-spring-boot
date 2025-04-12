package com.Kafka.Learning.notification.Notification.service.with.kafka.Consumers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class kafkaUserConsumers {

    @KafkaListener(topics = "user-random-topic")
    public void handleUserRandomTopic0(String message) {
        log.info("The message we get from topic is :{}",message);
    }

    @KafkaListener(topics = "user-random-topic")
    public void handleUserRandomTopic1(String message) {
        log.info("The message we get from topic is :{}",message);
    }

    @KafkaListener(topics = "user-random-topic")
    public void handleUserRandomTopic2(String message) {
        log.info("The message we get from topic is :{}",message);
    }

}
