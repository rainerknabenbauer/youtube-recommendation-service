package de.basedefender.youtube.domain.util;

import de.basedefender.youtube.domain.domain.HttpStatusCode;
import de.basedefender.youtube.domain.domain.YoutubeApiResponse;
import de.basedefender.youtube.domain.domain.impl.YoutubeApiResponseImpl;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;

public class YoutubeApiResponseUtil {

    public static YoutubeApiResponse getErrorResponse(HttpStatusCode httpStatusCode, String details) {

        ApiResponseStatus apiResponseStatus = new ApiResponseStatus(httpStatusCode, details);

        return new YoutubeApiResponseImpl(null, apiResponseStatus);    }
}
