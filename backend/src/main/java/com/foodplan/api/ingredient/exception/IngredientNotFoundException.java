package com.foodplan.api.ingredient.exception;

import com.foodplan.api.exception.AbstractNotFoundException;

public class IngredientNotFoundException extends AbstractNotFoundException {

    public IngredientNotFoundException(Long ingredientId) {
        super("Ingredient doesn't find with this given id : " + ingredientId);
    }

    public IngredientNotFoundException(String ingredientName) {
        super("Ingredient doesn't find with this given name : " + ingredientName);
    }

}
