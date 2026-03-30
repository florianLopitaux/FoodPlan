package com.foodplan.api.dish.exception;

import com.foodplan.api.dish.model.DishEntity;
import com.foodplan.api.food_item.model.FoodItemEntity;

public class IngredientAlreadyPresentExection extends RuntimeException {

    public IngredientAlreadyPresentExection(String dishName, String foodItemName) {
        super("The dish '" + dishName + "' already has the ingredient '" + foodItemName + "' in its recipe.");
    }

    public IngredientAlreadyPresentExection(DishEntity dish, FoodItemEntity foodItem) {
        this(dish.getName(), foodItem.getName());
    }
}
