package com.example.junit5starter.assertj;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.notIn;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.STRING;

import com.example.junit5starter.User;
import java.util.List;
import org.junit.jupiter.api.Test;

public class IterableTest {

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

    private List<User> getUsers() {
        return List.of(andrew(), betty(), sam());
    }

    private User sam() {
        return new User("sam", 25);
    }

    private User betty() {
        return new User("betty", 20);
    }

    private User andrew() {
        return new User("andrew", 32);
    }

    @Test
    void element_match_test() {
        List<User> users = getUsers();

        // Predicate를 파라미터로 받는다.
        assertThat(users).allMatch(user -> user.getName().length() > 0)
            .anyMatch(user -> user.getAge() > 25);
    }

    @Test
    void navigating_element_test() {
        List<User> users = getUsers();

        // element의 방향을 탐색하는것
        // 객체 간의 비교를 할때는 EqualsAndHashCode를 선언해줘야 한다
        assertThat(users).first().isEqualTo(andrew());
        assertThat(users).element(1).isEqualTo(betty());
        assertThat(users).last().isEqualTo(sam());

        assertThat(users).first(as(STRING)).startsWith("User");
    }

    @Test
    void single_element_test() {
        List<User> andrew = List.of(andrew());

        assertThat(andrew).singleElement()
            .isEqualTo(andrew());
    }

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
    }
}
