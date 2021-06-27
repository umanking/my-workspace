package com.example.basicwebflux.event.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TempEvent {

    private final String name;

    public TempEvent(String name) {
        this.name = name;
    }
}
