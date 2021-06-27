package com.example.springrestapi;

import com.example.springrestapi.domain.Member;
import com.example.springrestapi.repository.MemberRepository;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private Environment environment;
    @Autowired
    MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) {
        Member member = new Member();
        member.setName("andrew");
        member.setAge(32);
        member.setEmail("umanking@gmail.com");

        memberRepository.save(member);

        log.info("current active profile :{}", Arrays.toString(environment.getActiveProfiles()));

    }
}
