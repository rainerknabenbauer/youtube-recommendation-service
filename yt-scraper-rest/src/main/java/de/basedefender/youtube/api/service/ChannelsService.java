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
public class ChannelsService extends AbstractYouTubeService {


    public ChannelsService(YouTube youTube, ApiKey apiKey) {
        super(youTube, apiKey);
    }

    //TODO getChannelQuery()
    //TODO getVideoQuery()
    public YoutubeApiResponse searchVideos(String channelId) {

        YouTube.Search.List search;
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
