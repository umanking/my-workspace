package com.example.basicjava.java8.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEx {

    public static void main(String[] args) {

        // Arrays.sort 사용
        int[] ints = getInts();
        Arrays.sort(ints, 0, 3);
        System.out.println("ints = " + Arrays.toString(ints));

        // reverse order 사용!
//        Arrays.sort(Arrays.stream(ints).boxed().toArray(value -> new Integer[]{value}), Collections.reverseOrder());

        // Collections.sort 사용
        List<String> strings = Arrays.asList("betty", "andrew", "zen", "robert");
        Collections.sort(strings);
        System.out.println("strings = " + strings);

        List<String> result = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println("result = " + result);

        List<Integer> list = Arrays.stream(getInts()).boxed().collect(Collectors.toList());
        Collections.sort(list);

        // stream으로 처리 가능
        Arrays.stream(getInts()).boxed().sorted().collect(Collectors.toList());

        List<User> users = getUsers();
        List<User> collect = users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        List<User> collect1 = users.stream().sorted(Comparator.comparing(User::getAge).thenComparing(User::getName)).collect(Collectors.toList());

        System.out.println("users = " + users);
        System.out.println("collect = " + collect);
        System.out.println("collect1 = " + collect1);
    }

    private static int[] getInts() {
        int[] ints = {5, 4, 2, 1, 3};
        return ints;
    }

    public static List<User> getUsers() {
        User user = new User("andrew", 32);
        User user1 = new User("betty", 24);
        User user2 = new User("robert", 40);
        User user3 = new User("andy", 24);
        return Arrays.asList(user, user1, user2, user3);
    }

}
