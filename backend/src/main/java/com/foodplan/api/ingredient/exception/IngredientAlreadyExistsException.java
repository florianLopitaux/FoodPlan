package com.foodplan.api.ingredient.exception;

import com.foodplan.api.exception.AbstractAlreadyExistsException;

public class IngredientAlreadyExistsException extends AbstractAlreadyExistsException {

    public IngredientAlreadyExistsException(Long ingredientId) {
        super("Ingredient already exists with this given id: " + ingredientId);
    }

    public IngredientAlreadyExistsException(String ingredientName) {
        super("Ingredient already exists with this given name: " + ingredientName);
    }
}
