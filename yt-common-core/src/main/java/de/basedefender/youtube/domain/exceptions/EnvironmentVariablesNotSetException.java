package de.basedefender.youtube.domain.exceptions;

public class EnvironmentVariablesNotSetException extends RuntimeException {

    public EnvironmentVariablesNotSetException(String message, Throwable cause) {
        super(message, cause);
    }
}
