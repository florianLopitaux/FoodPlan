package com.foodplan.api.exception;

public abstract class AbstractAlreadyExistsException extends RuntimeException {

    public AbstractAlreadyExistsException(String message) {
        super(message);
    }

}
