package com.example.junit5starter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MathApplication {

    private final Calculator calculator;

    public int add(int a, int b) {
        return calculator.add(a, b);
    }

}
