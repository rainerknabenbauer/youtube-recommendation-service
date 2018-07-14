package de.basedefender.youtube.domain;

import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.domain.value.ApiResponseStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractYoutubeApiResponse implements YoutubeApiResponse {

    @Getter
    private final ApiResponseStatus apiResponseStatus;

}
