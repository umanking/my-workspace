package com.example.springrestapi.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private final HeavyService heavyService;

    public CacheService(HeavyService heavyService) {
        this.heavyService = heavyService;
    }

    @Cacheable(value = "heavyMethod", key = "#param")
    public String heavyMethod(String param) {
        return heavyService.veryHeavyMethod(param);
    }
}
