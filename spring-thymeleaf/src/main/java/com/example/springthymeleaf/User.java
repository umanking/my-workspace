package com.example.springthymeleaf;

import lombok.Data;

/**
 * @author Andrew
 * @since 2020-01-19
 */

@Data
//@Accessors(chain = true)
public class User {

    String firstName;
    String lastName;
    String city;
}
