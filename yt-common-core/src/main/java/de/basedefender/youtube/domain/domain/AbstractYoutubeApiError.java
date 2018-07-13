package de.basedefender.youtube.domain.domain;

import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;

public abstract class AbstractYoutubeApiError extends AbstractYoutubeApiResponse {

    public AbstractYoutubeApiError(ApiResponseStatus apiResponseStatus) {
        super(apiResponseStatus);
    }

}
