package com.example.basicjava.java8stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Geonguk Han
 * @since 2020-08-28
 */

@Data
@AllArgsConstructor
public class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;

}
