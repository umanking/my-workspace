package com.example.basicwebflux;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
public class Account {

    private final String name;
    private final int age;

    public Account(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
