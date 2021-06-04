package com.example.basicwebflux.practice;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

@Slf4j
public class ErrorOperatorExample {

    public static void main(String[] args) {

        Flux<Integer> range = Flux.range(0, 10);

        // 소비자 쪽에서 처리 error 이벤트 처리
        range
            .map(n -> 10 / n)
            .subscribe(
                data -> System.out.println(data),
                error -> log.error(error.getMessage()),
                () -> System.out.println("complete"));

        // 생산자쪽에서 처리함 onErrorRessume
        range.map(n -> 10 / n)
            .onErrorResume(error -> {
                log.error(error.getMessage());
                // new observable
                return range.skip(1).take(3).map(n -> 10 / n);
            })
            .subscribe(System.out::println);

        // retry
        range.map(n -> 10 / n)
            .retryWhen(Retry.backoff(1, Duration.ofSeconds(1)))
            .subscribe(data -> {
                log.info("data : " + data);
            });

    }

}
