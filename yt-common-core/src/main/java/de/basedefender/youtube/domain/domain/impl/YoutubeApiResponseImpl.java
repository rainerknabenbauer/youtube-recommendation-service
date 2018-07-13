package de.basedefender.youtube.domain.domain.impl;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.domain.domain.HttpStatusCode;
import de.basedefender.youtube.domain.domain.YoutubeApiResponse;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;
import lombok.RequiredArgsConstructor;

/**
 * Youtube API Response Wrapper for our REST API.
 */
@RequiredArgsConstructor
public class YoutubeApiResponseImpl implements YoutubeApiResponse {

    private final SearchListResponse searchListResponse;

    private final ApiResponseStatus apiResponseStatus;

    public ApiResponseStatus getApiResponseStatus() {
        return this.apiResponseStatus;
    }

    public SearchListResponse getResponse() {
        return this.searchListResponse;
    }

    public boolean successful() {
        return false;
    }
}
