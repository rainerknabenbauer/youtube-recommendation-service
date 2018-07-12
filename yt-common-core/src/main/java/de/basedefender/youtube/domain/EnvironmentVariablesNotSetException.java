package de.basedefender.youtube.domain;

public class EnvironmentVariablesNotSetException extends RuntimeException {

    public EnvironmentVariablesNotSetException(String message, Throwable cause) {
        super(message, cause);
    }
}
