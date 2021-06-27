package com.example.basicjava.algorithm.news.stack;

import java.util.Stack;

/**
 * @author Geonguk Han
 * @since 2020-07-23
 */
public class NTowerApp {
    public static void main(String[] args) {
        int[] intArray = {6, 9, 5, 7, 4};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < intArray.length; i++) {
            stack.push(intArray[i]);
        }

        System.out.println(stack);
        final Integer pop = stack.pop();
        int target, index;
        for (int i = 0; i <intArray.length ; i++) {
            if (intArray[i] > pop) {
                index = i;
            }


        }
    }
}
