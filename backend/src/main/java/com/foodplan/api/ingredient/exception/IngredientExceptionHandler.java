package com.foodplan.api.ingredient.exception;

import com.foodplan.api.exception.ApiError;
import com.foodplan.api.exception.GlobalExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IngredientExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(IngredientAlreadyPresentException.class)
    public ResponseEntity<ApiError> handleAlreadyPresent(IngredientAlreadyPresentException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(HttpStatus.BAD_REQUEST, request.getRequestURI(), ex);
    }
}
