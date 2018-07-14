package de.basedefender.youtube.api.util;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.domain.domain.AbstractYoutubeApiResponse;
import de.basedefender.youtube.domain.domain.HttpStatusCode;
import de.basedefender.youtube.domain.domain.SearchType;
import de.basedefender.youtube.domain.YoutubeApiSuccess;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;
import de.basedefender.youtube.domain.exceptions.EnvironmentVariablesNotSetException;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class ChannelUtils {

    private YouTube youtube;

    private String apiKey;

    private Long numberOfVideosReturned = 10L;

    @Value("${youtube.application.name}")
    private String applicationName;

    /**
     * Youtube Utils.
     */
    public ChannelUtils() {
        this.youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
                request -> { }).setApplicationName(this.applicationName).build();

        setEnvironment();
    }

    public ChannelUtils(Long numberOfVideosReturned) {
        this();
        this.numberOfVideosReturned = numberOfVideosReturned;
    }

    public AbstractYoutubeApiResponse searchVideosByChannel(String channelId) {

        YouTube.Search.List search;
        try {
            search = this.youtube.search().list("id,snippet");
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

        // Call the API and print results.
        try {
            SearchListResponse searchListResponse = search.execute();

            return new YoutubeApiSuccess(searchListResponse,
                    new ApiResponseStatus(HttpStatusCode.OK));

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
            this.apiKey = System.getenv("youtube.api.key");
        } catch (Exception ex) {
            throw new EnvironmentVariablesNotSetException("Environment variable 'youtube.api.key' not set.", ex);
        }
    }
}
