package de.basedefender.youtube.api.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.domain.SearchType;
import de.basedefender.youtube.domain.YoutubeApiSuccess;
import de.basedefender.youtube.domain.value.ApiKey;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SearchService extends AbstractYouTubeService {
    public SearchService(YouTube youTube, ApiKey apiKey) {
        super(youTube, apiKey);
    }

    /**
     * Get YouTube metadata required for other services.
     * ChannelId, VideoId, ..
     *
     * @param searchterm User input
     * @param searchType Service specific attribute
     * @return YouTube Metadata
     */
    public YoutubeApiResponse getMetadata(String searchterm, SearchType searchType) {

        YouTube.Search.List search;
        try {
            search = super.getYouTube().search().list("id,snippet");
        } catch (IOException ex) {
            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.SERVICE_UNAVAILABLE,
                    "Failed while initializing search for YouTube. " +
                            "Wrong parameters for YouTube.Search.List?");
        }

        search.setKey(super.getApiKey());

        search.setQ(searchterm);

        search.setType(searchType.toString());

        search.setMaxResults(super.getNumberOfVideosReturned());

        try {
            SearchListResponse searchListResponse = search.execute();
            return new YoutubeApiSuccess(searchListResponse);
        } catch (IOException ex) {
            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.BAD_REQUEST,
                    "Failed while executing search on YouTube. Wrong search parameter? " +
                            "Check Channel ID.");
        }
    }
}
