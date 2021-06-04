package com.example.basicwebflux.event.listener;

import com.example.basicwebflux.event.model.CustomEvent;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import lombok.Getter;

@Getter
public class EventListener {

    private static int eventCount;

    @Subscribe
    public void stringEvent(String event) {
        eventCount++;
        System.out.println("print event:" + event);
        System.out.println("event count: " + eventCount);
    }

    @Subscribe
    public void listenCustomEvenet(CustomEvent customEvent) {
        System.out.println("print:" + customEvent.getName());
        System.out.println("print:" + customEvent.getIssueDate());

    }

    /*@Subscribe
    public void listenCustomEvenet(Object customEvent) {
        CustomEvent event = (CustomEvent) customEvent;
        System.out.println("notExistCustomEvent!! ");
        System.out.println("print:" + event.getName());

    }*/

    @Subscribe
    public void listenDeadEvent(DeadEvent deadEvent) {
        System.out.println("dead event:" + deadEvent.getEvent());
        System.out.println("dead event:" + deadEvent.getSource());
    }

}
