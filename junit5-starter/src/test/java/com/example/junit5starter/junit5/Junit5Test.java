package com.example.junit5starter.junit5;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.junit5starter.User.RoleType;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class Junit5Test {

/*    @BeforeAll
    static void beforeAll() {
        System.out.println("한번만 실행됨 beforeAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("매 테스트 마다 실행됨 ");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("한번만 실행됨 afterAll");
    }

    @AfterEach
    void tearDown() {
        System.out.println("매 테스트 마다 실행됨 (afterEach)");
    }*/

    @Test
    @DisplayName("테스트 1")
    void test1() {
        System.out.println("test1");
    }

    @Test
    @Disabled("아직 테스트 하지 말것")
    @DisplayName("테스트 2")
    void test2() {
        System.out.println("test2");
    }

    @ParameterizedTest
    @NullSource
    void null_source_test(String input) {
        assertThat(input).isNull();
    }

    @ParameterizedTest
    @EmptySource
    void empty_source_test(String input) {
        assertThat(input).isEmpty();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null_and_empty_source_test(String input) {
        assertThat(Strings.isBlank(input)).isTrue();
    }

    @ParameterizedTest
    @EnumSource(RoleType.class)
    void enum_test(RoleType roleType) {
        assertThat(RoleType.values()).contains(roleType);
    }

    @ParameterizedTest
    @EnumSource(value = RoleType.class, names = {"ADMIN"}, mode = Mode.EXCLUDE)
    void enum_exclude_test(RoleType roleType) {
        assertThat(roleType).isEqualTo(RoleType.USER);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void csv_file_test(String firstColumn, String secondColumn) {
        assertThat(firstColumn.toUpperCase()).isEqualTo(secondColumn);
    }

}
