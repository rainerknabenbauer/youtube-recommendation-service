package de.basedefender.youtube.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractYoutubeApiResponse implements YoutubeApiResponse {

    @Getter
    private final ApiResponseStatus apiResponseStatus;

}
