package de.basedefender.youtube.domain;

import de.basedefender.youtube.domain.value.ApiResponseStatus;

public abstract class AbstractYoutubeApiError extends AbstractYoutubeApiResponse {

    public AbstractYoutubeApiError(ApiResponseStatus apiResponseStatus) {
        super(apiResponseStatus);
    }

}
