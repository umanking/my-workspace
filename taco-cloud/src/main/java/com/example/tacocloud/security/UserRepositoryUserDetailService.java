package com.example.tacocloud.security;

import com.example.tacocloud.data.UserRepository;
import com.example.tacocloud.tacos.User;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Geonguk Han
 * @since 2020-06-12
 */
@Service
public class UserRepositoryUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserRepositoryUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + "not found"));
        if (user == null) {
            throw new UsernameNotFoundException("User" + username + "not found");
        }
        return user;
    }
}
