package de.basedefender.youtube.api;

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
