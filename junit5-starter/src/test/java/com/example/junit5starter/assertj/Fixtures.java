package com.example.junit5starter.assertj;

import com.example.junit5starter.User;
import com.example.junit5starter.User.RoleType;
import java.util.List;

public class Fixtures {

    protected List<User> getUsers() {
        // age 순, desc  andrew > sam > betty
        // name순, acs andrew, betty, sam
        return List.of(betty(), andrew(), sam());
    }

    protected User sam() {
        return new User("sam", 25, RoleType.USER);
    }

    protected User betty() {
        return new User("betty", 20, RoleType.USER);
    }

    protected User andrew() {
        return new User("andrew", 32, RoleType.ADMIN);
    }
}
