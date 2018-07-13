package de.basedefender.youtube.domain.domain;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;
import lombok.Getter;

public abstract class AbstractYoutubeApiSuccess extends AbstractYoutubeApiResponse {

    @Getter
    private final SearchListResponse searchListResponse;

    public AbstractYoutubeApiSuccess(SearchListResponse searchListResponse,
                                     ApiResponseStatus apiResponseStatus) {
        super(apiResponseStatus);
        this.searchListResponse = searchListResponse;
    }
}
