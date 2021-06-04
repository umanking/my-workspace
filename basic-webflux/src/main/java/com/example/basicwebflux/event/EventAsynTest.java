package com.example.basicwebflux.event;

import com.example.basicwebflux.event.listener.EventMessageListner;
import com.google.common.eventbus.AsyncEventBus;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventAsynTest {

    public static void main(String[] args) {
        // async event 생성
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        AsyncEventBus asyncEventBus = new AsyncEventBus("message identifier", executorService);

        // listner 등록
        asyncEventBus.register(new EventMessageListner());

        // multi-thread event post
        Thread thread = new Thread(() -> asyncEventBus.post("new thread async evnet"));
        thread.start();

        // multi-thread event post
        Thread thread1 = new Thread(() -> asyncEventBus.post("new thread async evnet"));
        thread1.start();

    }
}
