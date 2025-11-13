package com.example.mini_project.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleValidationExceptions(Exception ex) {
        Map<String, String> error = Map.of(
                "error", "Bad Request",
                "message", "Missing or invalid required parameters: latitude and longitude."
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
