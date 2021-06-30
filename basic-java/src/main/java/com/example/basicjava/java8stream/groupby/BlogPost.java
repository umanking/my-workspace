package com.example.basicjava.java8stream.groupby;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Geonguk Han
 * @since 2020-08-28
 */

@Data
@AllArgsConstructor
public class BlogPost {

    private String title;
    private String author;
    private BlogPostType type;
    int likes;

}
