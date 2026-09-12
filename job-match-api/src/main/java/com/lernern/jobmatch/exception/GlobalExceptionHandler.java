package com.lernern.jobmatch.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Candidate not found
    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCandidateNotFound(
            CandidateNotFoundException ex) {

        Map<String, String> response = new HashMap<>();

        response.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // Job not found
    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleJobNotFound(
            JobNotFoundException ex) {

        Map<String, String> response = new HashMap<>();

        response.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // Validation error from @Valid on request body
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> response = new HashMap<>();

        // Field-level errors
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        response.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        // Class-level errors
        ex.getBindingResult()
                .getGlobalErrors()
                .forEach(error ->
                        response.put(
                                error.getObjectName(),
                                error.getDefaultMessage()
                        )
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // Validation error from @Min, @Max, etc.
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(
            ConstraintViolationException ex) {

        Map<String, String> response = new HashMap<>();

        ex.getConstraintViolations()
                .forEach(error ->
                        response.put(
                                error.getPropertyPath().toString(),
                                error.getMessage()
                        )
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // Any unexpected error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(
            Exception ex) {

        Map<String, String> response = new HashMap<>();

        response.put(
                "message",
                "An unexpected error occurred"
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}