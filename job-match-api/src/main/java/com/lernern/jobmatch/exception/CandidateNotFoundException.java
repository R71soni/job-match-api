package com.lernern.jobmatch.exception;

public class CandidateNotFoundException extends RuntimeException {

    public CandidateNotFoundException(String message) {
        super(message);
    }
}