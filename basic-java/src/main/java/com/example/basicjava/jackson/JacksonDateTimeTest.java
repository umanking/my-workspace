package com.example.basicjava.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class JacksonDateTimeTest {

    public static void main(String[] args) throws JsonProcessingException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper objectMapper = new ObjectMapper();
        
        Event event = new Event();
        event.setName("이벤트 1");
        event.setEventDate(LocalDateTime.now());

        String result = objectMapper.writeValueAsString(event);
        System.out.println("result = " + result);
    }

}
