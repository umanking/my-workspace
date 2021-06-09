package com.example.basicwebflux;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierTest {

    @Test
    void test1() {
        Flux.just("foo", "bar")
            .as(StepVerifier::create)
            .expectNextCount(2)
            .verifyComplete();
    }

    @Test
    void test2() {
        Account andrew = new Account("andrew", 32);
        Account mona = new Account("mona", 30);

        insertAccounts(andrew, mona)
            .as(StepVerifier::create)
            .expectNext(andrew, mona)
            .expectComplete()
            .log()
            .verify();
    }

    @Test
    void test3() {
        Account andrew = new Account("andrew", 32);
        Account mona = new Account("mona", 30);

        insertAccounts(andrew, mona)
            .as(StepVerifier::create)
            .assertNext(account -> assertAll(account, andrew))
            .assertNext(account -> assertAll(account, mona))
            .expectComplete().log().verify();
    }

    private void assertAll(Account actual, Account expected) {
        assertThat(actual)
            .usingRecursiveComparison()
            .isEqualTo(expected);
    }

    private Flux<Account> insertAccounts(Account... account) {
        return Flux.just(account);
    }

}
