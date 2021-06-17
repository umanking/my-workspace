package com.example.basicwebflux;

import lombok.Getter;

@Getter
public class Account {

    private final static String NAME = "HELLO";

    private final Long id;
    private final String name;
    private final int age;

    public Account(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
