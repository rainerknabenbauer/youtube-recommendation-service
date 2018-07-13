package de.basedefender.youtube.domain.domain.value;

import de.basedefender.youtube.domain.domain.HttpStatusCode;
import lombok.Value;

/**
 * API Response Status.
 */
@Value
public class ApiResponseStatus {

    public ApiResponseStatus(HttpStatusCode httpStatusCode, String details) {
        this.httpStatusCode = httpStatusCode.getHttpCode();
        this.httpMessage = httpStatusCode;
        this.details = details;
    }

    public ApiResponseStatus(HttpStatusCode httpStatusCode) {
        this.httpStatusCode = httpStatusCode.getHttpCode();
        this.httpMessage = httpStatusCode;
        this.details = httpStatusCode.toString();
    }

    private final Integer httpStatusCode;

    private final HttpStatusCode httpMessage;

    private final String details;

}
