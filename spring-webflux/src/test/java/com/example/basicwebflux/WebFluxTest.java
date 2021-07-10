package com.example.basicwebflux;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebFluxTest {

    @Test
    void test() {
        // hot 예제
        Mono<String> hotMono = Mono.just(getName());
        hotMono.subscribe(System.out::println);
        hotMono.subscribe(System.out::println);
        hotMono.subscribe(System.out::println);
        hotMono.subscribe(System.out::println);

        System.out.println("================");

        //cold 예제
        Mono<String> coldMono = Mono.create(monoSink -> monoSink.success(getName()));
        coldMono.subscribe(System.out::println);
        coldMono.subscribe(System.out::println);
        coldMono.subscribe(System.out::println);

        System.out.println("==========");

        // cold > hot으로 전환한다.
        Mono<String> cache = coldMono.cache();
        cache.subscribe(System.out::println);
        cache.subscribe(System.out::println);
        cache.subscribe(System.out::println);

        cache.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public String getName() {
        System.out.println("getName methdo call");
        return "andrew";
    }


    @Test
    void test2() {
        // 1,3만 흘러가고 0이면 그 즉시 중단.
        Flux.just(1, 3, 0).map(
                i -> "result : " + (100 / i)
        ).onErrorReturn("not divided zero").subscribe(System.out::println);

    }
}
