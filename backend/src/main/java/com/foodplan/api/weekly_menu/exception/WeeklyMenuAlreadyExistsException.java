package com.foodplan.api.weekly_menu.exception;

public class WeeklyMenuAlreadyExistsException extends RuntimeException {

    public WeeklyMenuAlreadyExistsException(String name) {
        super("Weekly menu already exists with this given name : " + name);
    }
}
