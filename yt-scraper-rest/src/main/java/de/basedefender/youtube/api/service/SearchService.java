package de.basedefender.youtube.api.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.YoutubeApiResponse;
import de.basedefender.youtube.domain.AbstractYouTubeService;
import de.basedefender.youtube.enums.HttpStatusCode;
import de.basedefender.youtube.enums.SearchType;
import de.basedefender.youtube.api.YoutubeApiSuccess;
import de.basedefender.youtube.value.ApiKey;
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
    
    public YoutubeApiResponse getVideos(String channelId) {
        
        /**
         * 1. Get channel information
         * 2. Extract uploaded videos ID (playlist presumable)
         * 3. ? search with ID ?
         */
        
        YouTube.Search.List search;  //TODO switch search to channel instead of regular search
        try {
            search = super.getYouTube().search().list("id,snippet,contentDetails");
        } catch (IOException ex) {
            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.SERVICE_UNAVAILABLE,
                "Failed while initializing search for YouTube.");
        }
        
        search.setKey(super.getApiKey());
        
        search.setChannelId(channelId);
        
        // think about .setType()
        search.setType(SearchType.VIDEO.toString());            //TODO what else to query
        
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
