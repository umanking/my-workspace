package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Geonguk Han
 * @since 2020-06-17
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
