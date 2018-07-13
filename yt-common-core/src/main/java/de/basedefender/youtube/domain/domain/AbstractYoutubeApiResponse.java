package de.basedefender.youtube.domain.domain;

import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractYoutubeApiResponse implements YoutubeApiResponse {

    @Getter
    private final ApiResponseStatus apiResponseStatus;

}
