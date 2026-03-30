package com.foodplan.api.dish.exception;

import com.foodplan.api.exception.ApiError;
import com.foodplan.api.exception.GlobalExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.foodplan.api.dish")
public class DishExceptionHandler {

    @ExceptionHandler(DishNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(DishNotFoundException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.NOT_FOUND,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

    @ExceptionHandler(DishAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleAlreadyExists(DishAlreadyExistsException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

    @ExceptionHandler(IngredientAlreadyPresentException.class)
    public ResponseEntity<ApiError> handleAlreadyPresent(IngredientAlreadyPresentException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }
}
