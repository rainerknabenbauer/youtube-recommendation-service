package de.basedefender.youtube.api;

import de.basedefender.youtube.enums.HttpStatusCode;
import lombok.Value;

/**
 * API Response Status.
 */
@Value
public class ApiResponseStatus {

    public ApiResponseStatus(HttpStatusCode httpStatusCode, String details) {
        this.httpCode = httpStatusCode.getHttpCode();
        this.httpStatusCode = httpStatusCode;
        this.details = details;
    }

    public ApiResponseStatus(HttpStatusCode httpStatusCode) {
        this.httpCode = httpStatusCode.getHttpCode();
        this.httpStatusCode = httpStatusCode;
        this.details = httpStatusCode.getDetails();
    }

    private final Integer httpCode;

    private final HttpStatusCode httpStatusCode;

    private final String details;

}
