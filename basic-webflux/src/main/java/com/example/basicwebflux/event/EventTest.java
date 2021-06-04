package com.example.basicwebflux.event;

import com.example.basicwebflux.event.listener.EventListener;
import com.example.basicwebflux.event.model.CustomEvent;
import com.example.basicwebflux.event.model.TempEvent;
import com.google.common.eventbus.EventBus;
import java.time.LocalDateTime;

public class EventTest {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus();

        // listner 등록
        eventBus.register(new EventListener());

        eventBus.post("event1");
        eventBus.post("event2");
        eventBus.post("event3");

        // custom event 생성
        CustomEvent customEvent = new CustomEvent();
        customEvent.setName("크리스마스 이벤트");
        customEvent.setIssueDate(LocalDateTime.of(2020, 12, 25, 0, 0, 0));

        // custom event 보내기
        eventBus.post(customEvent);

        // deadEvent(TempEvent객체를 Subscribe하는게 없다.)
        eventBus.post(new TempEvent("임시 이벤트, 하지만 listner가 존재하지 않는다."));


    }

}
