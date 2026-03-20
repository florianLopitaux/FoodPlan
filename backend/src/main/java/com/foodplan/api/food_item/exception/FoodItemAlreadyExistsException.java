package com.foodplan.api.food_item.exception;

public class FoodItemAlreadyExistsException extends RuntimeException {

    public FoodItemAlreadyExistsException(Long foodItemId) {
        super("FoodItem already exists with this given id: " + foodItemId);
    }

    public FoodItemAlreadyExistsException(String foodItemName) {
        super("FoodItem already exists with this given name: " + foodItemName);
    }

}
