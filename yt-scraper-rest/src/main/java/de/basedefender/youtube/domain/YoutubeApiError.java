package de.basedefender.youtube.domain;

import de.basedefender.youtube.domain.domain.AbstractYoutubeApiError;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;

/**
 * Youtube API Response Wrapper for our REST API.
 */
public class YoutubeApiError extends AbstractYoutubeApiError {

    public YoutubeApiError(ApiResponseStatus apiResponseStatus) {
        super(apiResponseStatus);
    }

    public ApiResponseStatus getApiResponseStatus() {
        return super.getApiResponseStatus();
    }

}
