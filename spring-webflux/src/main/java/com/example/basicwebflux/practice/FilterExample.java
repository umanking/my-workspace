package com.example.basicwebflux.practice;

import reactor.core.publisher.Flux;

/**
 * @author Andrew
 * @since 2021-01-17
 */
public class FilterExample {
    public static void main(String[] args) {
//
//        Flux.range(0, 100)
//                .takeWhile(i -> i != 50)
//                .subscribe(System.out::println);
//
//        System.out.println("=======");
//        Flux.interval(1, 100)
//                .skip(Duration.ofSeconds(3))
//                .subscribe(System.out::println);

//        Flux.interval(Duration.ofSeconds(1))
//                .subscribe(System.out::println);

        Flux.range(1, 15)
                .skipLast(3)
                .subscribe(System.out::println);

    }
}
