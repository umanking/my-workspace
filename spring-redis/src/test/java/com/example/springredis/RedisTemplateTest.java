package com.example.springredis;

import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RedisTemplateTest {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, String> hashOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, String> zSetOperations;

    @BeforeEach
    void setUp() {

        listOperations.rightPush("test::task", "a");
        listOperations.rightPush("test::task", "b");
        listOperations.rightPush("test::task", "c");

        hashOperations.put("test:user:andrew", "name", "geonguk");
        hashOperations.put("test:user:andrew", "age", "32");

        setOperations.add("test:user:andrew:hobby", "swim");
        setOperations.add("test:user:andrew:hobby", "guitar");

        zSetOperations.add("test:user:andrew:wish", "money", 2);
        zSetOperations.add("test:user:andrew:wish", "house", 1);

    }

    @Test
    void name() {

        Map<String, String> entries =
            hashOperations.entries("test:user:andrew");
        System.out.println(entries);

        Set<String> members = setOperations.members("test:user:andrew:hobby");
        System.out.println(members);

        String s = listOperations.leftPop("test:task");
        System.out.println(s);

        Long size = zSetOperations.size("test:user:andrew:wish");
        System.out.println(size);


    }
}
