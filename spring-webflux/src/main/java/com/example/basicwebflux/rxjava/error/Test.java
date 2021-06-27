package com.example.basicwebflux.rxjava.error;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Test {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);
        integerFlux
            .doOnRequest(value -> System.out.println(value))
            .doOnNext(x -> System.out.println("doOnNext: " + x))
            .subscribe();

        Flux<Object> objectFlux = Flux.error(new RuntimeException("custom"))
            .doOnError(th -> log.error("onError: " + th))
            .onErrorReturn("FALL BACK");

        objectFlux.subscribe(System.out::println);

        // onNext, onComplete, onError에 대해 호출함

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Flux.just(1, 2, 3, 4, 5).doOnEach(val -> {
            System.out.println("===========");
            System.out.println(val.isOnSubscribe());
            System.out.println(val.isOnComplete());
            System.out.println("value:" + val.get());
            atomicInteger.incrementAndGet();
        }).subscribe();

        System.out.println(atomicInteger.get());

    }

}
