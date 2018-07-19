package de.basedefender.youtube.util;

import de.basedefender.youtube.api.YoutubeApiError;
import de.basedefender.youtube.api.AbstractYoutubeApiError;
import de.basedefender.youtube.enums.HttpStatusCode;
import de.basedefender.youtube.api.ApiResponseStatus;

public class YoutubeApiResponseUtil {

    /**
     * Bundles Youtube API errors.
     *
     * @param httpStatusCode Youtube API Error Code
     * @param details Custom API details message
     * @return Bundled Youtube API Error
     */
    public static AbstractYoutubeApiError getErrorResponse(HttpStatusCode httpStatusCode, String details) {

        ApiResponseStatus apiResponseStatus = new ApiResponseStatus(httpStatusCode, details);

        return new YoutubeApiError(apiResponseStatus);
    }
}
