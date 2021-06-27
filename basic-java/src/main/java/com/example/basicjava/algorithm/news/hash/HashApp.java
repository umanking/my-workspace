package com.example.basicjava.algorithm.news.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Geonguk Han
 * @since 2020-07-15
 */
public class HashApp {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "119238394", "12"}));
        System.out.println(solution(new String[]{"123", "456", "7869"}));
    }

    public static boolean solution(String[] phone_book) {

        // 문자열 length 크기별로 정렬
        final List<String> collect = Arrays.stream(phone_book)
            .sorted(Comparator.comparing(String::length))
            .collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {
            final String basis = collect.get(i);

            for (int j = i + 1; j < collect.size(); j++) {
                final String s = collect.get(j);
                if (s.startsWith(basis)) {
                    return false;
                }
            }
        }

        return true;
    }
}

