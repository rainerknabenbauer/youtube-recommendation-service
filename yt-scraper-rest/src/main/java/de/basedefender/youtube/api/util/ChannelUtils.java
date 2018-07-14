package de.basedefender.youtube.api.util;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.YoutubeApiSuccess;
import de.basedefender.youtube.domain.AbstractYoutubeApiResponse;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.domain.SearchType;
import de.basedefender.youtube.domain.value.ApiResponseStatus;
import de.basedefender.youtube.exceptions.EnvironmentVariablesNotSetException;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class ChannelUtils {

    private final YouTube youTube;

    @Value("${youtube.application.numberOfVideosReturned}")
    private Long numberOfVideosReturned;

    private String apiKey;

    /**
     * Youtube Utils.
     */
    public ChannelUtils(YouTube youTube) {
        this.youTube = youTube;
        setEnvironment();
    }

    public AbstractYoutubeApiResponse searchVideosByChannel(String channelId) {

        YouTube.Search.List search;
        try {
            search = this.youTube.search().list("id,snippet");
        } catch (IOException ex) {
            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.SERVICE_UNAVAILABLE,
                    "Failed while initializing search for YouTube.");
        }

        // Set your developer key from the {{ Google Cloud Console }} for
        // non-authenticated requests. See:
        // {{ https://cloud.google.com/console }}
        search.setKey(this.apiKey);
        search.setChannelId(channelId);

        // Restrict the search results to only include videos. See:
        // https://developers.google.com/youtube/v3/docs/search/list#type
        search.setType(SearchType.VIDEO.toString());

        // To increase efficiency, only retrieve the fields that the
        // application uses.
        //search.setFields("items(id/kind,id/videoId,snippet/title,
        // snippet/thumbnails/default/url)");
        // TODO Set Filter
        search.setMaxResults(this.numberOfVideosReturned);

        return executeSearch(search);
    }

    private AbstractYoutubeApiResponse executeSearch(YouTube.Search.List search) {
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


    /**
     * Initializes required environment variables.
     */
    private void setEnvironment() {
        try {
            this.apiKey = System.getenv("youTube.api.key");
        } catch (Exception ex) {
            throw new EnvironmentVariablesNotSetException("Environment variable 'youTube.api.key' not set.", ex);
        }
    }
}
