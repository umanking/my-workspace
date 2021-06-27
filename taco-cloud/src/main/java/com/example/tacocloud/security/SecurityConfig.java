package com.example.tacocloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Geonguk Han
 * @since 2020-06-11
 * <p>
 * 사용자 HTTP 요청 경로에 대한 접근 제한과 같은 보안 관련 처리를 한다.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    DataSource dataSource;

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * handle http request
     * 보안 규칙을 적용한다.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/design", "orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").access("permitAll()")

                .and()
//                .httpBasic() // 기본 로그인 페이지 (Spring에서 제공함)
                .formLogin()
                .loginPage("/login")


                .and()
                .logout()
                .logoutSuccessUrl("/")


                .and()
                .csrf()
        ;
    }

    /**
     * about user authentication
     * 유저의 인증을 설정한다.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // inMemeory
        /*auth.inMemoryAuthentication()
                .withUser("user1")
                .password("{noop}1234")
                .and()
                .withUser("user2")
                .password("{noop}1234")
                .authorities("ROLE_USER");*/

        // jdbc
        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users" +
                                "where username=?"
                ).authoritiesByUsernameQuery(
                "select username, authority from authorities" +
                        "where username=?"
        ).passwordEncoder(new NoEncodingPasswordEncoder());*/

        // jpa로 데이터베이스에서 읽어서 사용한다.
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(encoder());

    }
}
