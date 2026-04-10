package com.foodplan.api.weekly_menu.exception;

public class WeeklyMenuAlreadyExistsException extends RuntimeException {

    public WeeklyMenuAlreadyExistsException(Long id) {
        super("Weekly menu already exists with this given id : " + id);
    }

    public WeeklyMenuAlreadyExistsException(String name) {
        super("Weekly menu already exists with this given name : " + name);
    }
}
