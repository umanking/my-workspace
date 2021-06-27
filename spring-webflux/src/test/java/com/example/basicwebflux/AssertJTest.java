package com.example.basicwebflux;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.Test;

public class AssertJTest {

    @Test
    void ignore_field_test() {
        Account actual = new Account(1L , "andrew", 32);
        Account expected = new Account(2L, "andrew", 32);

        // 동등성 (필드값)비교
        assertThat(actual)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expected);
    }

    @Test
    void ignore_null_field_test() {
        Account actual = new Account(1L , "ddd", 32);
        Account expected = new Account(2L, "andrew", 32);

        RecursiveComparisonConfiguration recursiveComparisonConfiguration = RecursiveComparisonConfiguration.builder()
            .withIgnoredFields("id", "name").build();

        // 동등성 (필드값)비교
        assertThat(actual)
            .usingRecursiveComparison(recursiveComparisonConfiguration)
            .isEqualTo(expected);

    }
}
