package de.basedefender.youtube.util;

import de.basedefender.youtube.domain.YoutubeApiError;
import de.basedefender.youtube.domain.domain.AbstractYoutubeApiError;
import de.basedefender.youtube.domain.domain.HttpStatusCode;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;

public class YoutubeApiResponseUtil {

    public static AbstractYoutubeApiError getErrorResponse(HttpStatusCode httpStatusCode, String details) {

        ApiResponseStatus apiResponseStatus = new ApiResponseStatus(httpStatusCode, details);

        return new YoutubeApiError(apiResponseStatus);
    }
}
