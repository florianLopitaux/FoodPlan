package com.foodplan.api.food_item.exception;

import com.foodplan.api.exception.ApiError;
import com.foodplan.api.exception.GlobalExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.foodplan.api.food_item")
public class FoodItemExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(FoodItemNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(FoodItemNotFoundException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.NOT_FOUND,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

    @ExceptionHandler(FoodItemAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleAlreadyExists(FoodItemAlreadyExistsException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }
}
