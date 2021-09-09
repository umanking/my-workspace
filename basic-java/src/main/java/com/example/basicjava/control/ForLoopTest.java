package com.example.basicjava.control;

public class ForLoopTest {

    public static void main(String[] args) {
        int total = 0;

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                continue;
            }
            total += i;
        }
        //2,4,6,8
        System.out.println("total = " + total);

    }

}
