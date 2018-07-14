package de.basedefender.youtube.domain;

import com.google.api.client.json.GenericJson;
import de.basedefender.youtube.domain.value.ApiResponseStatus;
import lombok.Getter;

public abstract class AbstractYoutubeApiSuccess extends AbstractYoutubeApiResponse {

    @Getter
    private final GenericJson genericJson;

    public AbstractYoutubeApiSuccess(GenericJson genericJson,
                                     ApiResponseStatus apiResponseStatus) {
        super(apiResponseStatus);
        this.genericJson = genericJson;
    }
}
