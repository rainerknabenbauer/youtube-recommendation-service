package de.basedefender.youtube.api.util;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.domain.EnvironmentVariablesNotSetException;
import de.basedefender.youtube.domain.SearchExecutionException;
import de.basedefender.youtube.domain.SearchType;
import de.basedefender.youtube.domain.YoutubeListNotRetrievedException;

import java.io.IOException;

public class YtChannelUtils {

    private YouTube youtube;

    private String apiKey;

    private Long number_of_videos_returned = 10L;

    /**
     * Youtube Utils.
     */
    public YtChannelUtils() {
        this.youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                // no-op override
            }
        }).setApplicationName("basedefender-yt-scraper").build();

        setEnvironment();
    }

    public YtChannelUtils(Long number_of_videos_returned) {
        this();
        this.number_of_videos_returned = number_of_videos_returned;
    }

    public SearchListResponse searchVideos(String channelId) {
        // get query
        // execute query
        // return result (create domain object)

        // Define the API request for retrieving search results.
        YouTube.Search.List search;
        try {
            search = this.youtube.search().list("id,snippet");
        } catch (IOException ex) {
            throw new YoutubeListNotRetrievedException("Youtube search list not retrieved.", ex);
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
        //search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
        // TODO Set Filter
        search.setMaxResults(number_of_videos_returned);

        // Call the API and print results.
        try {
            return search.execute();
        } catch (IOException ex) {
            throw new SearchExecutionException("Search execution failed.", ex);
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
