package com.example.springredis;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CFuture {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "andrew";

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(supplier)
                .whenComplete(((s, throwable) -> {
                    if (s != null) {
                        log.info(s);
                    }else{
                        log.error(throwable.getMessage());
                    }
                }));

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            log.info("이 부분이 비동기 처리");
            return "hello";
        });
        cf.thenAccept(s -> log.info(s));

        log.info("exit");
    }

}
