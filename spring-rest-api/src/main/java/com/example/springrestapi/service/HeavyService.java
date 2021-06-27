package com.example.springrestapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HeavyService {

    public String veryHeavyMethod(String param) {
        log.info("call very heavy method : {}", param);
        return "heavy method with " + param;
    }

}
