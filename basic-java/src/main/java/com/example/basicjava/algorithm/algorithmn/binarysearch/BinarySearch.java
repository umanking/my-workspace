package com.example.basicjava.algorithm.algorithmn.binarysearch;

/**
 * @author Geonguk Han
 * @since 2020-04-11
 */
public class BinarySearch {

    public static void main(String[] args) {
        // 항상 정렬되어 있어야 한다.
        int[] intArrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 20, 30, 50};
        System.out.println(solvewhile(intArrays, 10));

    }

    public static int solve(int[] intArrays, int target) {
        int lower = 0;
        int upper = intArrays.length;

        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            if (target == intArrays[middle]) {
                return middle;
            } else if (target > intArrays[middle]) {
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return -1;
    }

    public static int solve2(int[] ints, int target) {
        int lower = 0;
        int upper = ints.length;
        int count = 0;
        while (lower <= upper) {
            System.out.println(count++);

            int middle = (lower + upper) / 2;
            // 중간값이랑 같으면 리턴
            if (ints[middle] == target) {
                return middle;
            } else if (ints[middle] < target) {
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }
        return -1;
    }

    public static int solvewhile(int[] arrays, int target) {
        int low, high, mid;
        low = 0;
        high = arrays.length - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arrays[mid] == target) return mid;
            if (arrays[mid] > target) {
                high = mid - 1;
            }
            if (arrays[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }


}
