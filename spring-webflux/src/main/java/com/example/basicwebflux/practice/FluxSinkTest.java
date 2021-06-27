package com.example.basicwebflux.practice;

import java.time.Duration;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class FluxSinkTest {

    public static void main(String[] args) {

        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while (true) {
                fluxSink.next(System.currentTimeMillis());
            }
        }).sample(Duration.ofSeconds(2)).publish();


        // subscribe를 호출해도, 실제 connect()를 호출하기 전까지는 방출하지 않는다.
        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);

        publish.connect();

    }

}
