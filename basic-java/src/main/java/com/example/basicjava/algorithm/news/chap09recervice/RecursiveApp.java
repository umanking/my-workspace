package com.example.basicjava.algorithm.news.chap09recervice;

/**
 * @author Geonguk Han
 * @since 2020-07-05
 */
// 파일 시스템의 directory 탐색
public class RecursiveApp {
    public static void main(String[] args) {

        // countdown 10 to 0
//        countDown(10);
        countDown2(10);

    }

    private static void countDown(int number) {
        for (int i = number; i >= 0; i--) {
            System.out.println(i);
        }
    }

    private static void countDown2(int number) {
        System.out.println(number);
        int number1 = number - 1;
        if (number1 == 0) {
            return;
        }
        countDown2(number1);


    }
}
