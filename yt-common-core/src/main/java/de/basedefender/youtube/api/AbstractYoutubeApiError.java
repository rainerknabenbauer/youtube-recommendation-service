package de.basedefender.youtube.api;

public abstract class AbstractYoutubeApiError extends AbstractYoutubeApiResponse {

    public AbstractYoutubeApiError(ApiResponseStatus apiResponseStatus) {
        super(apiResponseStatus);
    }

}
