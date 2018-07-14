package de.basedefender.youtube.exceptions;

import jdk.nashorn.internal.objects.annotations.Setter;

public class SearchExecutionException extends RuntimeException {

    public SearchExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
