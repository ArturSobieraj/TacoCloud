package com.tc.tacocloud.model.data;

import com.tc.tacocloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();
}
