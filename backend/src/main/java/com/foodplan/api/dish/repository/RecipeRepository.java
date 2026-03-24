package com.foodplan.api.dish.repository;

import com.foodplan.api.dish.model.RecipeEntity;
import com.foodplan.api.dish.model.RecipeID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, RecipeID> {

}
