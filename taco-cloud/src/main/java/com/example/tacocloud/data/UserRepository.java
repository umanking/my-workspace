package com.example.tacocloud.data;

import com.example.tacocloud.tacos.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Geonguk Han
 * @since 2020-06-12
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
