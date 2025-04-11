package com.Kafka.Learning.User.User.service.with.kafka.Controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public UserControllers(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {

        kafkaTemplate.send("user-random-topic", message);

        return ResponseEntity.ok("Message received");
    }
}
//4XnDg5cOTfWroo-Oskpcyw
