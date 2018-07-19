package de.basedefender.youtube.enums;

public enum HttpStatusCode {

    OK(200, "OK"),
    NO_CONTENT(204,  "No Content"),

    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable")
    ;

    private int httpCode;
    private String details;
    private String text;

    HttpStatusCode(int code, String details) {
        this.httpCode = code;
        this.details = details;
        this.text = Integer.toString(code);
    }

    /**
     * Gets the HTTP status httpCode
     * @return the status httpCode number
     */
    public int getHttpCode() {
        return this.httpCode;
    }

    /**
     * Gets the HTTP status httpCode as a text string
     * @return the status httpCode as a text string
     */
    public String toString() {
        return this.text;
    }

    /**
     * Get the details
     * @return the details of the status httpCode
     */
    public String getDetails() {
        return this.details;
    }

}
