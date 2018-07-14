package de.basedefender.youtube;

import de.basedefender.youtube.domain.value.ApiResponseStatus;

/**
 * REST Response wrapper.
 */
public interface YoutubeApiResponse {

    ApiResponseStatus getApiResponseStatus();

}
