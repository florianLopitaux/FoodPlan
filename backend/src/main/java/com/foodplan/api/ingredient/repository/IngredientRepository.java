package com.foodplan.api.ingredient.repository;

import com.foodplan.api.ingredient.model.IngredientEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    Set<IngredientEntity> findByNameContainingIgnoreCase(String name);

    Optional<IngredientEntity> findByName(String name);

}
