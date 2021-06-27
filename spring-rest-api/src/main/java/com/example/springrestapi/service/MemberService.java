package com.example.springrestapi.service;

import com.example.springrestapi.domain.Member;
import com.example.springrestapi.exception.CustomException;
import com.example.springrestapi.repository.MemberRepository;
import java.util.List;
import java.util.function.Supplier;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Andrew
 * @since 2020-11-11
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(notExistException(memberId));
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long memberId, Member member) {
        Member existMember = memberRepository.findById(memberId).orElseThrow(notExistException(memberId));
        return memberRepository.save(existMember.updateMember(member));
    }

    private Supplier<CustomException> notExistException(Long memberId) {
        return () -> new CustomException("not exist memberId: : " + memberId);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
