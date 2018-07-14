package de.basedefender.youtube.api.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.YoutubeApiSuccess;
import de.basedefender.youtube.domain.AbstractYoutubeApiResponse;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.domain.value.ApiKey;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@RequiredArgsConstructor
public abstract class AbstractYouTubeService {

    @Getter
    private final YouTube youTube;

    private final ApiKey apiKey;

    @Getter
    @Value("${youtube.application.numberOfVideosReturned}")
    private Long numberOfVideosReturned;


    public AbstractYoutubeApiResponse executeSearch(YouTube.Search.List search) {
        // Call the API and print results.
        try {
            SearchListResponse searchListResponse = search.execute();

            return new YoutubeApiSuccess(searchListResponse);

        } catch (IOException ex) {

            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.BAD_REQUEST,
                    "Failed while executing search on YouTube. Wrong search parameter? " +
                            "Check Channel ID.");
        }
    }

    public String getApiKey() {
        return this.apiKey.toString();
    }
}
