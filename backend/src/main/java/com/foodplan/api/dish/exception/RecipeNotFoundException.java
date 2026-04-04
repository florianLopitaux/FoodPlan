package com.foodplan.api.dish.exception;

import com.foodplan.api.dish.model.RecipeID;
import com.foodplan.api.exception.AbstractNotFoundException;

public class RecipeNotFoundException extends AbstractNotFoundException {

    public RecipeNotFoundException(String dishName, Long ingredientId) {
        super("Recipe not found with this id [dishName='" + dishName + "', ingredientId=" + ingredientId + "]");
    }

    public RecipeNotFoundException(RecipeID recipeId) {
        this(recipeId.getDishName(), recipeId.getIngredientId());
    }
}
