package de.basedefender.youtube.api.service;

import com.google.api.services.youtube.YouTube;
import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.domain.SearchType;
import de.basedefender.youtube.domain.value.ApiKey;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SearchService extends AbstractYouTubeService {
    public SearchService(YouTube youTube, ApiKey apiKey) {
        super(youTube, apiKey);
    }

    public YoutubeApiResponse getMetadata(String searchterm, SearchType searchType) {

        YouTube.Search.List search;
        try {
            search = super.getYouTube().search().list("id,snippet");
        } catch (IOException ex) {
            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.SERVICE_UNAVAILABLE,
                    "Failed while initializing search for YouTube.");
        }

        search.setKey(super.getApiKey());

        search.setQ(searchterm);

        search.setType(searchType.toString());

        search.setMaxResults(super.getNumberOfVideosReturned());

        return super.executeSearch(search);
    }

}
