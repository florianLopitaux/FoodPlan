package com.foodplan.api.ingredient.exception;

public class IngredientAlreadyExistsException extends RuntimeException {

    public IngredientAlreadyExistsException(Long ingredientId) {
        super("Ingredient already exists with this given id: " + ingredientId);
    }

    public IngredientAlreadyExistsException(String ingredientName) {
        super("Ingredient already exists with this given name: " + ingredientName);
    }

}
