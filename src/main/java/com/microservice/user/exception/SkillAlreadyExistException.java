package com.microservice.user.exception;

public class SkillAlreadyExistException extends RuntimeException {
    public SkillAlreadyExistException(String message) {
        super(message);
    }
}
