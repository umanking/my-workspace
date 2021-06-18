package com.example.junit5starter.assertj;

import com.example.junit5starter.User;
import java.util.List;

public class Fixtures {

    protected List<User> getUsers() {
        return List.of(andrew(), betty(), sam());
    }

    protected User sam() {
        return new User("sam", 25);
    }

    protected User betty() {
        return new User("betty", 20);
    }

    protected User andrew() {
        return new User("andrew", 32);
    }
}
