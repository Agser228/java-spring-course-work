package ru.agser.server.exception;

public class IllegalEmailStateException extends RuntimeException {
    public IllegalEmailStateException(String message) {
        super(message);
    }
}
