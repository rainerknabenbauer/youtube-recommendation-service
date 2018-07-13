package de.basedefender.youtube.domain.domain;

import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;

/**
 * REST Response wrapper.
 */
public interface YoutubeApiResponse {

    ApiResponseStatus getApiResponseStatus();

}
