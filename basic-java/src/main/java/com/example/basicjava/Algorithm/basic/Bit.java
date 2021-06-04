package com.example.basicjava.Algorithm.basic;

public class Bit {

    public static void main(String[] args) {
        System.out.println(4 & 1);
//
//        System.out.println(1 << 0);
//        System.out.println(1 << 1);
//        System.out.println(1 << 2);
//        System.out.println(1 << 3);

        System.out.println("===========");
        System.out.println(0 << 0); //0
        System.out.println(0 << 1); //2
        System.out.println(0 << 2); //4
        System.out.println(0 << 3);//6


        System.out.println("===============");
        char[] array = new char[]{'A', 'B'};
        for (int i = 0; i < (1 << array.length); i++) {

            System.out.print("{ ");
            for (int j = 0; j < array.length; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(array[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
