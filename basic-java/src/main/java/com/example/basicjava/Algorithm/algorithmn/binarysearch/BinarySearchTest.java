package com.example.basicjava.Algorithm.algorithmn.binarysearch;

import java.util.Arrays;

public class BinarySearchTest {

    public static void main(String[] args) {
        //{ 17, 28, 43, 67, 88, 92, 100 }
        int[] array = {17, 28, 43, 67, 88, 92, 100};

        System.out.println(solve(array, 43));
        System.out.println(solve2(array, 43));
    }

    public static void log(int value) {
        System.out.println(value);
    }

    public static void log(int[] value) {
        System.out.println(Arrays.toString(value));
    }

    public static int solve(int[] array, int target) {
        // 정렬된 배열인 경우, 배열의 중간 값을 찾는다.
        int middleIndex = array.length / 2;
        int middleValue = getMiddleValue(array, middleIndex);
        // 중간값과 target 값이 같으면
        if (middleValue == target) {
            return middleValue;
        }
        // 중간값과 target값을 비교해서, 왼쪽배열을 탐색할지, 오른쪽 배열을 탐색할지 정한다.
        // target < 중간값이 더 큰경우, 왼쪽배열인 경우, 배열의 끝값을 변경해서 새로운 배열을 만든다.
        if (target < middleValue) {
            int[] leftArray = Arrays.copyOfRange(array, 0, middleIndex);
            log(leftArray);
            return solve(leftArray, target);
        } else {
            // 오른쪽 배열인 경우, 배열의 시작값을 중간값으로 변경해서 새로운 배열을 만든다.
            int[] rightArray = Arrays.copyOfRange(array, middleIndex, array.length);
            log(rightArray);
            return solve(rightArray, target);
        }
        // 새롭게 생성된 배열로 위의 과정을 반복한다.
    }

    public static int solve2(int[] array, int target) {
        int middleIndex = array.length / 2 ;
        int middleValue = array[middleIndex];

        if (middleValue == target) return middleValue;
        if (middleValue > target) {
            int[] leftArray = Arrays.copyOfRange(array, 0, middleIndex);
            return solve2(leftArray, target);
        } else {
            int[] rightArray = Arrays.copyOfRange(array, middleIndex, array.length);
            return solve2(rightArray, target);
        }
    }

    private static int getMiddleValue(int[] array, int middleIndex) {
        return array[middleIndex];
    }

}
