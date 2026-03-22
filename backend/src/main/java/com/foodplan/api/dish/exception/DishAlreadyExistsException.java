package com.foodplan.api.dish.exception;

public class DishAlreadyExistsException extends RuntimeException {

    public DishAlreadyExistsException(String dishName) {
        super("Dish already exists with this given name: " + dishName);
    }
}
