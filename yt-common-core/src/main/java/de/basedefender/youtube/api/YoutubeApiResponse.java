package de.basedefender.youtube.api;

import de.basedefender.youtube.api.ApiResponseStatus;

/**
 * REST Response wrapper.
 */
public interface YoutubeApiResponse {

    ApiResponseStatus getApiResponseStatus();

}
