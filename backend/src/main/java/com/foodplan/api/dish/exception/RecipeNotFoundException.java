package com.foodplan.api.dish.exception;

import com.foodplan.api.dish.model.RecipeID;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(String dishName, Long ingredientID) {
        super("Recipe not found with these id [dishName='" + dishName + "', ingredientID:'" + ingredientID + "']");
    }

    public RecipeNotFoundException(RecipeID recipeId) {
        this(recipeId.getDishName(), recipeId.getIngredientId());
    }
}
