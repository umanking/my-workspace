package com.example.basicwebflux.practice;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class FluxThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 10)
            .filter(n -> n > 4)
            .subscribeOn(Schedulers.boundedElastic())
            .subscribe((data) -> log.info("data(thread) :" + data));

        Flux.range(1, 10)
            .filter(n -> n > 4)
            .subscribe((data) -> log.info("data(main):" + data));

        Flux.range(1, 10)
            .count()
            .subscribe(System.out::println);

        Flux.concat(
            Flux.range(1, 10),
            Flux.range(10, 10),
            Flux.range(20, 10)
        )
            .count()
            .subscribe(System.out::println);

        /*Flux.range(1, 10)
            .scan(0, (x, y) -> (x + y))
            .subscribe(System.out::println);*/

        Flux.range(1, 10)
            .sort((i1, i2) -> i2 - i1)
            .reduce((x, y) -> x - y)
            .subscribe(System.out::println);

        Flux.range(1, 10)
            .reduce((x, y) -> y - x)
            .subscribe(System.out::println);

        // 다른 스레드에서 동작
        /*Flux.interval(Duration.ofMillis(100)).subscribe(data -> log.info("data :" + data));

        Thread.sleep(1000L);*/

        Mono<LocalDateTime> just = Mono.just(LocalDateTime.now()); // 선언과 동시에 통지
        Mono<LocalDateTime> defer = Mono.defer(() -> Mono.just(LocalDateTime.now())); // 나중으로 미룬다. 소비하는 시점에 통지가 작동

        just.subscribe(data -> log.info("구독1 just:  " + data));
        defer.subscribe(data -> log.info("구독1 defer: " + data));

        Thread.sleep(3000L);

        just.subscribe(data -> log.info("구독2 just:  " + data));
        defer.subscribe(data -> log.info("구독2 defer: " + data));


    }

}
