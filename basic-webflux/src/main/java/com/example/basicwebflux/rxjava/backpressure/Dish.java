package com.example.basicwebflux.rxjava.backpressure;

public class Dish {

    private final byte[] oneKb = new byte[1024];

    private final int id;

    public Dish(int id) {
        this.id = id;
        System.out.println("Created: " + id);

    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
