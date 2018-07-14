package de.basedefender.youtube;

import de.basedefender.youtube.domain.AbstractYoutubeApiError;
import de.basedefender.youtube.domain.value.ApiResponseStatus;

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
