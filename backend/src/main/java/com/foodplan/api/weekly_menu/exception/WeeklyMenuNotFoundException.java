package com.foodplan.api.weekly_menu.exception;

import com.foodplan.api.exception.AbstractNotFoundException;

public class WeeklyMenuNotFoundException extends AbstractNotFoundException {

    public WeeklyMenuNotFoundException(Long id) {
        super("WeeklyMenu not found with this given id : " + id);
    }

    public WeeklyMenuNotFoundException(String name) {
        super("WeeklyMenu not found with this given name : " + name);
    }
}
