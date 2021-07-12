package com.example.basicjava.java8.stream.groupby;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Geonguk Han
 * @since 2020-08-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tuple {
    private BlogPostType type;
    private String author;
}
