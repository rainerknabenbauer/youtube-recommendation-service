package de.basedefender.youtube.api;

import com.google.api.client.json.GenericJson;
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
