package com.foodplan.api.food_item.exception;

public class FoodItemNotFoundException extends RuntimeException {

    public FoodItemNotFoundException(Long foodItemId) {
        super("FoodItem doesn't find with this given id : " + foodItemId);
    }

    public FoodItemNotFoundException(String foodItemName) {
        super("FoodItem doesn't find with this given name : " + foodItemName);
    }

}
