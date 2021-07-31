package com.example.basicjava.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class JacksonTest {

    @Test
    void name() throws JsonProcessingException {
        Event event = new Event();
        event.setName("event1");
        event.setEventDate(LocalDateTime.now());

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(event);

        System.out.println("result = " + result);

    }
}