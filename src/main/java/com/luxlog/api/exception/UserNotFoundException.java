package com.luxlog.api.exception;

public class UserNotFoundException extends LuxLogException{
    private static final String MESSAGE = "그 유저가 존재하지 않습니다.";

    public UserNotFoundException(Throwable cause) {
        super(MESSAGE,cause);
    }

    public UserNotFoundException() {
        super(MESSAGE);
    }

    @Override
    public int getStatus() {
        return 404;
    }
}
