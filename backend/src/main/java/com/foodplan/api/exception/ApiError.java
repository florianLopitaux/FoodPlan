package com.foodplan.api.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiError {
    // FIELDS
    private final String path;
    private final LocalDateTime timestamp;
    private final int statusCode;
    private final String statusName;
    private final String exceptionName;
    private final String message;
    private List<String> details;


    // CONSTRUCTOR
    public ApiError(String path, int statusCode, String statusName, String exceptionName, String message) {
        this.path = path;
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.exceptionName = exceptionName;
        this.message = message;
        this.details = new ArrayList<>();
    }

    public ApiError(String path, int statusCode, String statusName, String exceptionName, String message, List<String> details) {
        this(path, statusCode, statusName, exceptionName, message);
        this.details = details;
    }


    // GETTERS
    public String getPath() {
        return this.path;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public String getExceptionName() {
        return this.exceptionName;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getDetails() {
        return this.details;
    }
}
