package com.foodplan.api.dish.exception;

import com.foodplan.api.exception.AbstractNotFoundException;

public class DishNotFoundException extends AbstractNotFoundException {

    public DishNotFoundException(String dishName) {
        super("Dish doesn't find with this given name : " + dishName);
    }
}
