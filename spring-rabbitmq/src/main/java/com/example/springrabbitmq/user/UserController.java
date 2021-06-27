package com.example.springrabbitmq.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("createUser :{}", user);

        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", user);
        // status 200
        return ResponseEntity.ok(user);
    }

}
