package com.example.basicjava.algorithm.basic;

import java.util.Scanner;

public class ArrayInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[100];

        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(score[i] + " ");
        }
    }
}
