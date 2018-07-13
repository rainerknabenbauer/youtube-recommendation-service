package de.basedefender.youtube.domain.domain;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;

/**
 * REST Response wrapper.
 */
public interface YoutubeApiResponse {

    ApiResponseStatus getApiResponseStatus();

    SearchListResponse getResponse();

    boolean successful();
}
