package com.example.basicwebflux.practice;

import reactor.core.publisher.Flux;

/**
 * @author Andrew
 * @since 2021-01-17
 */
public class FlatMapExample {

    public static void main(String[] args) {

        // 구구단 만들기
        Flux.range(2, 1)
                .flatMap(num -> Flux.range(1, 9).map(i -> num + "*" + i + "=" + num * i))
                .subscribe(System.out::println);


        System.out.println("======= quiz 1");
        Flux.range(1, 15)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .subscribe(System.out::println);

        System.out.println("===== quiz 2 ");
        Flux.range(1, 9)
                .filter(n -> n % 2 == 0)
                .flatMap(n -> Flux.range(1, 9).map(row -> n + "*" + row + "=" + n * row))
                .subscribe(System.out::println);
    }
}
