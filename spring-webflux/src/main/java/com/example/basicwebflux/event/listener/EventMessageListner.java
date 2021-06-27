package com.example.basicwebflux.event.listener;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventMessageListner {

    @AllowConcurrentEvents
    @Subscribe
    public void listenEventMessage(String message) throws InterruptedException {
        log.info("listening message start >>");
        for (int i = 0; i < 10; i++) {
            log.info("receiving message:{}, variable:{} ",message, i);
            TimeUnit.SECONDS.sleep(1L);
        }
        log.info("listening message done >>");
    }


}
