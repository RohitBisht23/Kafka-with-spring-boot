package com.Kafka.Learning.User.User.service.with.kafka.Controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserControllers {

    //Kafka template
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.user_random_topic}")
    private  String KAFKA_RANDOM_USER_TOPIC;

    public UserControllers(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {

        for(int i=0; i<1000; i++) {
            kafkaTemplate.send(KAFKA_RANDOM_USER_TOPIC, message+" "+i);
        }

        return ResponseEntity.ok("Message received");
    }
}
//4XnDg5cOTfWroo-Oskpcyw
