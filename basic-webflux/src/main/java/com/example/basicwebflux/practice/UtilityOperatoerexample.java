package com.example.basicwebflux.practice;

import reactor.core.publisher.Flux;

public class UtilityOperatoerexample {

    public static void main(String[] args) {

//        Flux.range(1, 5)
//            .map(num -> {
//                long time = 1000L;
//                if (num == 4) {
//                    time = 1500L;
//                }
//                try {
//                    Thread.sleep(time);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                return num;
//            }).timeout(Duration.ofMillis(1200))
//            .subscribe(System.out::println);

        Flux.range(1, 5)
            .materialize()
            .subscribe(notification -> {
                String notificationType = notification.isOnNext() ? "onNext() " : (notification.isOnError() ? "onError()" : "onComplete");
                System.out.println(notificationType);
                System.out.println("data:" + notification.get());
            });
    }

}
