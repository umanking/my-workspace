package com.example.springrestapi.api;

import com.example.springrestapi.domain.Member;
import com.example.springrestapi.service.MemberService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrew
 * @since 2020-11-11
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody @Valid Member member) {
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, Member newMember) {
        return ResponseEntity.ok(memberService.updateMember(id, newMember));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    // todo: excel download

}
