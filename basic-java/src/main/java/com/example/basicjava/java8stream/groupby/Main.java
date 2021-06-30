package com.example.basicjava.java8stream.groupby;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * {@link "https://www.baeldung.com/java-groupingby-collector"}
 */
public class Main {

    public static void main(String[] args) {
        List<BlogPost> posts = dummy();

        // group by a single colmn
        Map<BlogPostType, List<BlogPost>> collect = posts.stream().collect(groupingBy(BlogPost::getType));
        System.out.println("collect = " + collect);

        // group by complex map key type
        Map<Tuple, List<BlogPost>> collect1 = posts.stream().collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

        // Map의 value 타입 변경
        Map<String, Set<BlogPost>> collect2 = posts.stream().collect(groupingBy(BlogPost::getAuthor, toSet()));

        // groupping by multiple fields (이름으로 그룹핑, 그 후에 Type으로 그룹핑)
        Map<String, Map<BlogPostType, List<BlogPost>>> collect3 = posts.stream().collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));
        System.out.println("collect3 = " + collect3);


    }

    public static List<BlogPost> dummy() {
        return List.of(
            new BlogPost("java", "andrew", BlogPostType.GUIDE, 10),
            new BlogPost("java2", "andrew", BlogPostType.GUIDE, 10),
            new BlogPost("java3", "andrew", BlogPostType.REVIEW, 10)
//            new BlogPost("spring", "toby", BlogPostType.REVIEW, 15),
//            new BlogPost("cleanCode", "robert", BlogPostType.GUIDE, 30),
//            new BlogPost("jpa", "kim", BlogPostType.NEWS, 20)


        );
    }
}
