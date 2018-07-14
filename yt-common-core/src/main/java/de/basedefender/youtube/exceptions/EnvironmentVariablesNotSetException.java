package de.basedefender.youtube.exceptions;

public class EnvironmentVariablesNotSetException extends RuntimeException {

    public EnvironmentVariablesNotSetException(String message, Throwable cause) {
        super(message, cause);
    }
}
