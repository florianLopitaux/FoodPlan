package com.foodplan.api.dish.exception;

public class DishNotFoundException extends RuntimeException {

    public DishNotFoundException(String dishName) {
        super("Dish doesn't find with this given name : " + dishName);
    }
}
