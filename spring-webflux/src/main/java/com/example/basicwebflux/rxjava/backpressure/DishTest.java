package com.example.basicwebflux.rxjava.backpressure;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class DishTest {

    public static void main(String[] args) {

        Flux.range(1, 1_000_000)
            .subscribeOn(Schedulers.boundedElastic())
            .map(Dish::new)
            .subscribe(x-> {
                System.out.println("Washing: " + x);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
    }

}
