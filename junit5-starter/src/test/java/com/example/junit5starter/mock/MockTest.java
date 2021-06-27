package com.example.junit5starter.mock;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.junit5starter.Calculator;
import com.example.junit5starter.MathApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockTest {


    @Mock
    Calculator calculator;

    @InjectMocks
    MathApplication mathApplication;

    @Test
    void addTest() {
        // Given
        given(calculator.add(anyInt(), anyInt())).willReturn(10);

        // When
        // Then
        verify(calculator, times(1)).add(1, 2);
    }
}
