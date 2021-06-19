package com.example.junit5starter.assertj;

import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.notIn;
import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.example.junit5starter.User;
import com.example.junit5starter.User.Order;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class IterableAssertionsTest extends Fixtures {


    /**
     * chceck iterable contents(contains) test
     */
    @Test
    void iterable_contents_test() {
        List<String> list = List.of("1", "1", "2", "3");

        // 포함되어 있니
        assertThat(list).contains("1", "2");
        // 중복된 값도 반영됨
        assertThat(list).containsOnly("2","1","3");
        // 순서 까지 정확해야함
        assertThat(list).containsExactly("1", "1", "2", "3");
        // 순서 정확하지 않아도됨
        assertThat(list).containsExactlyInAnyOrder("2", "3", "1", "1");
        assertThat(list).contains("1").contains("1").containsSequence("2", "3");
        // 오직 한번만 있는 값들
        assertThat(list).containsOnlyOnce("2", "3");
        assertThat(list).containsAnyOf("2");

    }

    /**
     * verify element test (satisfy, match)
     */
    @Test
    void element_satisfy_test() {
        List<User> users = getUsers();

        // Consumer를 파라미터로 받는다.
        // allSatisfy 모든 조건을 만족하는
        assertThat(users).allSatisfy(user -> {
            assertThat(user.getName()).isNotEqualTo("mike");
            assertThat(user.getAge()).isGreaterThanOrEqualTo(20);
        });

        // 적어도 하나의 element 값을 충족시키는
        assertThat(users).anySatisfy(user -> {
            assertThat(user.getName()).isEqualTo("andrew");
            assertThat(user.getAge()).isEqualTo(32);
        });

        // 어떤 조건도 만족하지 않는
        assertThat(users).noneSatisfy(user -> {
            assertThat(user.getName()).isEqualTo("BTS");
        });
    }

    @Test
    void element_match_test() {
        List<User> users = getUsers();

        // Predicate를 파라미터로 받는다.
        assertThat(users).allMatch(user -> user.getName().length() > 0)
            .anyMatch(user -> user.getAge() > 25);
    }

    /**
     * navigating to given element test
     */
    @Test
    void navigating_element_test() {
        List<User> users = getUsers();

        // element의 방향을 탐색하는것
        // 객체 간의 비교를 할때는 EqualsAndHashCode를 선언해줘야 한다
        assertThat(users).first().isEqualTo(andrew());
        assertThat(users).element(1).isEqualTo(betty());
        assertThat(users).last().isEqualTo(sam());
    }

    @Test
    void single_element_test() {
        List<User> andrew = List.of(andrew());

        assertThat(andrew).singleElement()
            .isEqualTo(andrew());
    }

    /**
     * filtering element test
     */
    @Test
    void filter_test() {
        List<User> users = getUsers();

        // Filtering - Predicate
        assertThat(users).filteredOn(user -> user.getName().startsWith("and"))
            .containsOnly(andrew());

        // Filtering - Property
        assertThat(users).filteredOn("name", "andrew")
            .containsOnly(andrew());

        assertThat(users).filteredOn("name", in("andrew", "sam"))
            .containsOnly(andrew(), sam());

        assertThat(users).filteredOn("name", notIn("mike", "nu"))
            .containsOnly(andrew(), sam(), betty());

        // Property 를 메서드 레퍼런스로 표현가능하지만, not, in, notIn 오퍼레이터는 사용불가함
        assertThat(users)
            .filteredOn(User::getName, "andrew")
            .filteredOn(User::getAge, 32)
            .containsOnly(andrew());


        // null value 값을 찾는다.
        assertThat(users).filteredOnNull("name").isEmpty();

    }

    @Test
    void filtering_matching_given_assertion_test() {
        List<User> users = getUsers();

        assertThat(users).filteredOnAssertions(user -> {
            assertThat(user.getAge()).isGreaterThanOrEqualTo(25);
        }).containsOnly(sam(), andrew());
    }

    @Test
    void filtering_condition_test() {
        List<User> users = getUsers();
        Condition<User> olderUser = new Condition<>(user -> user.getAge() >= 25, "olderUser");

        assertThat(users).filteredOn(olderUser)
            .containsOnly(andrew(), sam());

        // Predicate로 그냥 넘겨서 람다식으로 작성하는게 더욱 편한듯
        assertThat(users).filteredOn(user -> user.getAge() >= 25)
            .containsOnly(andrew(), sam());
    }

    /**
     *
     */
    @Test
    void extracting_single_value_test() {
        List<User> users = getUsers();
        // wrong answer ❌ -------> extranct getNameList
        List<String> collect = users.stream().map(User::getName).collect(Collectors.toList());
        assertThat(collect).contains("andrew", "betty", "sam");

        // correct answer 🟢
        assertThat(users)
            .extracting("name")
            .contains("andrew", "betty", "sam");

        // 람다 표현식 가능
        assertThat(users)
            .extracting(User::getName)
            .contains("andrew", "betty", "sam");

        // map으로 변환해서 가능
        assertThat(users)
            .map(User::getName)
            .contains("andrew", "betty", "sam");

        // 2번째 파라미터로 강력하게 타입을 지정해서 > 이렇게 할거면 람다표현식이 나은듯👍
        assertThat(users)
            .extracting("name", String.class)
            .contains("andrew", "betty", "sam");
    }

    @Test
    void extracting_multiple_values_test() {
        List<User> users = getUsers();

        assertThat(users).extracting("name", "age")
            .contains(tuple("andrew", 32),
                tuple("betty", 20),
                tuple("sam", 25)
            );

        assertThat(users).extracting(User::getName, User::getAge)
            .contains(tuple("andrew", 32),
                tuple("betty", 20),
                tuple("sam", 25)
            );
    }

    @Test
    void extracting_flatMap_extracting_value_test() {
        User andrew = new User("andrew", 32, List.of(
            new Order("선풍기", 30_000),
            new Order("책장", 80_000))
        );

        Order order = new Order("선풍기", 30_000);

        List<User> users = List.of(andrew);
        assertThat(users).flatExtracting(User::getOrders)
            .contains(order);

        assertThat(users).flatExtracting("orders")
            .contains(order);
    }

    @Test
    void comparing_element_specific_comparator_test() {
        List<User> users = getUsers();
        assertThat(users).usingElementComparator(
            Comparator.comparing(User::getRoleType)).contains(andrew());
    }
}
