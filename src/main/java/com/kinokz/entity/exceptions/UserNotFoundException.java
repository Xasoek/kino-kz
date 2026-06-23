package com.kinokz.entity.exceptions;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(String massage) {
        super(massage);
    }
}
