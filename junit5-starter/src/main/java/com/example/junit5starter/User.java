package com.example.junit5starter;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    private String name;
    private int age;
    private List<Order> orders;
    private RoleType roleType;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, List<Order> orders) {
        this.name = name;
        this.age = age;
        this.orders = orders;
    }

    public User(String name, int age, RoleType roleType) {
        this.name = name;
        this.age = age;
        this.roleType = roleType;
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Order {

        private String product;
        private int amount;
    }

    @Getter
    public enum RoleType {
        ADMIN, USER
    }


}
