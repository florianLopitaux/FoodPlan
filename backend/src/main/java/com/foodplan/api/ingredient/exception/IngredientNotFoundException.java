package com.foodplan.api.ingredient.exception;

public class IngredientNotFoundException extends RuntimeException {

    public IngredientNotFoundException(Long ingredientId) {
        super("Ingredient doesn't find with this given id : " + ingredientId);
    }

    public IngredientNotFoundException(String ingredientName) {
        super("Ingredient doesn't find with this given name : " + ingredientName);
    }

}
