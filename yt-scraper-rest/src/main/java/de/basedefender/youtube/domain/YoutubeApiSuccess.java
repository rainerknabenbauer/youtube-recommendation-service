package de.basedefender.youtube.domain;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.domain.domain.AbstractYoutubeApiSuccess;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;

/**
 * Youtube API Response Wrapper for our REST API.
 */
public class YoutubeApiSuccess extends AbstractYoutubeApiSuccess {


    public YoutubeApiSuccess(SearchListResponse searchListResponse, ApiResponseStatus apiResponseStatus) {
        super(searchListResponse, apiResponseStatus);
    }

    /**
     * Youtube API status after sending query.
     * @return API response status
     */
    public ApiResponseStatus getApiResponseStatus() {
        return super.getApiResponseStatus();
    }

    /**
     * Full Youtube API response data.
     * @return Youtube API reponse
     */
    public SearchListResponse getResponse() {
        return super.getSearchListResponse();
    }

}
