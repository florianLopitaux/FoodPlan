package com.foodplan.api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                request.getRequestURI(),
                "Unexpected Error",
                ex.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                MethodArgumentNotValidException.class.getSimpleName(),
                ex.getMessage()
        );
    }

    @ExceptionHandler(AbstractNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(AbstractNotFoundException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.NOT_FOUND,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }

    @ExceptionHandler(AbstractAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleAlreadyExists(AbstractAlreadyExistsException ex, HttpServletRequest request) {
        return GlobalExceptionHandler.buildError(
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }


    // Method to easily build error body to response with handler methods
    public static ResponseEntity<ApiError> buildError(HttpStatus status, String path, String exceptionName, String message) {
        final ApiError error = new ApiError(
                path,
                status.value(),
                status.name(),
                exceptionName,
                message
        );

        return ResponseEntity.status(error.getStatusCode()).body(error);
    }

    public static ResponseEntity<ApiError> buildError(HttpStatus status, String path, String exceptionName, String message, List<String> details) {
        final ApiError error = new ApiError(
                path,
                status.value(),
                status.name(),
                exceptionName,
                message,
                details
        );

        return ResponseEntity.status(error.getStatusCode()).body(error);
    }
}
