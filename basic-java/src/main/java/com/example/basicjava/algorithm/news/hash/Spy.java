package com.example.basicjava.algorithm.news.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Geonguk Han
 * @since 2020-07-17
 */
public class Spy {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"},
                {"red_sunglasses", "eyewear"}};

//        System.out.println(solution2(clothes));
//        System.out.println(solution3(clothes));

        System.out.println(practiceGroupingBy(clothes));

    }

    public static int solution(String[][] clothes) {
        // wrong answer
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            final String key = clothes[i][1];
            int count = 1;
            if (map.containsKey(key)) {
                int integer = map.get(key);
                map.put(key, integer + 1);
            } else {
                map.put(key, count);
            }
        }

        int totalCount = 0;
        final Collection<Integer> values = map.values();
        final Integer reduce = values.stream().reduce(0, Integer::sum);
        final Integer reduce1 = values.stream().reduce(1, (a, b) -> a * b);
        totalCount = reduce + reduce1;

        return totalCount;
        
    }


    public static int solution2(String[][] clothes) {
        // answer

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            final String key = clothes[i][1];
            int count = 1;
            if (map.containsKey(key)) {
                int integer = map.get(key);
                map.put(key, integer + 1);
            } else {
                map.put(key, count);
            }
        }

        Collection<Integer> values = map.values();
        List<Integer> collect = values.stream().map(v -> v + 1).collect(Collectors.toList());
        int i = collect.stream().reduce(1, (a, b) -> a * b) -1;
        return i;
    }

    public static int solution3(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.counting())))
                .values()
                .stream()
                .map(v -> v + 1)
                .reduce(1L, (a, b) -> a * b).intValue() - 1;
    }

    public static int practiceGroupingBy(String[][] clothes) {

        Map<String, List<String>> collect = Arrays.stream(clothes)
                .collect(Collectors.groupingBy(p -> p[1], Collectors.mapping(p -> p[0], Collectors.toList())));

        System.out.println(collect.toString());

        return 1;
    }
}
