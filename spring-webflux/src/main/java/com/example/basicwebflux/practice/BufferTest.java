package com.example.basicwebflux.practice;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class BufferTest {

    public static void main(String[] args) {
        Flux<Integer> oddInteger = Flux.range(1, 10)
            .buffer(1, 2)
            .flatMapIterable(list -> list);

        Flux.just(1).interval(Duration.ofMillis(100))
            .take(50)
            .subscribe(System.out::println);

    }

}
