package de.basedefender.youtube.api.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.api.util.SearchUtils;
import de.basedefender.youtube.domain.YoutubeApiSuccess;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.domain.value.ApiKey;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class VideosService extends AbstractYouTubeService {

    public VideosService(YouTube youTube, ApiKey apiKey) {
        super(youTube, apiKey);
    }

    /**
     * Get comments for a specific video.
     * @param videoId YouTube Video ID
     * @return Comments
     */
    public YoutubeApiResponse getComments(String videoId) {

        YouTube.CommentThreads.List search;
        try {
            search = super.getYouTube()
                    .commentThreads().list("snippet,replies");
        } catch (IOException ex) {
            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.SERVICE_UNAVAILABLE,
                    "Failed while initializing search for YouTube. " +
                            "Wrong parameters for YouTube.Search.List?");
        }

            search.setKey(super.getApiKey());

            search.setVideoId(videoId);

        try {
            CommentThreadListResponse response = search.execute();
            return new YoutubeApiSuccess(response);
        } catch (IOException ex) {
            ex.printStackTrace();
            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.BAD_REQUEST,
                    "Failed while executing search on YouTube. Wrong search parameter? " +
                            "Check Video ID.");
        }

    }

}
