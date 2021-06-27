package com.example.springthymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Andrew
 * @since 2020-01-19
 */
@Data
@AllArgsConstructor
public class Item {

    private String name;
    private int price;

}
