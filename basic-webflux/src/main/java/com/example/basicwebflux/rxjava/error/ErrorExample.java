package com.example.basicwebflux.rxjava.error;

import reactor.core.publisher.Flux;

public class ErrorExample {

    public static void main(String[] args) {
        Flux.create(fluxSink -> fluxSink.next(1).next(2)).subscribe(System.out::println);
    }

}
