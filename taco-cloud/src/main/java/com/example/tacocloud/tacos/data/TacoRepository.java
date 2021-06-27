package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Geonguk Han
 * @since 2020-06-17
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
