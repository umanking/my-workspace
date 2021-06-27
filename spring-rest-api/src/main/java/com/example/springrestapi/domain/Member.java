package com.example.springrestapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Andrew
 * @since 2020-11-11
 */
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "email cannot be null")
    @Email
    private String email;

    @Min(value = 19)
    @Max(value = 100)
    private int age;

    public Member updateMember(Member newMember) {
        this.name = newMember.getName();
        this.email = newMember.getEmail();
        this.age = newMember.getAge();
        return this;
    }
}
