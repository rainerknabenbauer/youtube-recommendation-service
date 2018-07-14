package de.basedefender.youtube;

import com.google.api.client.json.GenericJson;
import de.basedefender.youtube.domain.AbstractYoutubeApiSuccess;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.domain.value.ApiResponseStatus;

/**
 * Youtube API Response Wrapper for our REST API.
 */
public class YoutubeApiSuccess extends AbstractYoutubeApiSuccess {


    public YoutubeApiSuccess(GenericJson genericJson) {
        super(genericJson, new ApiResponseStatus(HttpStatusCode.OK));
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
    public GenericJson getResponse() {
        return super.getGenericJson();
    }

}
