package com.example.tacocloud.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Geonguk Han
 * @since 2020-06-12
 */
public class NoEncodingPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
