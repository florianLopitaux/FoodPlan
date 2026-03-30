package com.foodplan.api.dish.exception;

import com.foodplan.api.dish.model.DishEntity;
import com.foodplan.api.ingredient.model.IngredientEntity;

public class IngredientAlreadyPresentException extends RuntimeException {

    public IngredientAlreadyPresentException(String dishName, String ingredientName) {
        super("The dish '" + dishName + "' already has the ingredient '" + ingredientName + "' in its recipe.");
    }

    public IngredientAlreadyPresentException(DishEntity dish, IngredientEntity ingredient) {
        this(dish.getName(), ingredient.getName());
    }
}
