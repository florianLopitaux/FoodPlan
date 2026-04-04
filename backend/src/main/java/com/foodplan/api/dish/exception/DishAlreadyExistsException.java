package com.foodplan.api.dish.exception;

import com.foodplan.api.exception.AbstractAlreadyExistsException;

public class DishAlreadyExistsException extends AbstractAlreadyExistsException {

    public DishAlreadyExistsException(String dishName) {
        super("Dish already exists with this given name: " + dishName);
    }
}
