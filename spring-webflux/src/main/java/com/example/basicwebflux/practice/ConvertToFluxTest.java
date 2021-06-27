package com.example.basicwebflux.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConvertToFluxTest {

    public static void main(String[] args) {
//        toFluxUsingFlatmapMany(monoOfList()).subscribe();
        toFluxUsingFlatMapIterable(monoOfList()).subscribe();

    }

    private static Mono<List<String>> monoOfList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        return Mono.just(list);
    }

    private static <T> Flux<T> toFluxUsingFlatmapMany(Mono<List<T>> monoList) {
        return monoList.flatMapMany(Flux::fromIterable)
            .log();
    }

    private static <T> Flux<T> toFluxUsingFlatMapIterable(Mono<List<T>> monoList) {
        return monoList.flatMapIterable(Function.identity())
            .log();
    }

}
