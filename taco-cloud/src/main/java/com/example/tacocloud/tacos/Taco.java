package com.example.tacocloud.tacos;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Geonguk Han
 * @since 2020-06-16
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NonNull
    @Size(min = 5, message = "name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "you must choose at least 1 ingredient")
    @ManyToMany(targetEntity = Ingredient.class)
    private List<String> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
