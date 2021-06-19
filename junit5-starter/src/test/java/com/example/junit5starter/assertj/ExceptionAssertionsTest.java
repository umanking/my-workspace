package com.example.junit5starter.assertj;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionAssertionsTest {


    @Test
    void thrown_by_test() {
        // assertThatTrownBy()  ~  catchThrowable 대안으로 씀
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        })
            .isInstanceOf(Exception.class)
            .hasMessageContaining("bo")
            .hasMessage("boom!");

    }

    @Test
    void exception_test() {

        assertThatExceptionOfType(IOException.class)
            .isThrownBy(() -> {
                throw new IOException("bang!");
            })
            .withMessage("%s!", "bang")
            .withNoCause();

        // 메서드로 NullPointer, IllegalArgument, IllegalState, IOException 제공해준다.
        assertThatIOException().isThrownBy(() -> {
            throw new IOException("something wrong");
        })
            .withMessage("%s!", "bang")
            .withNoCause();

    }
}
