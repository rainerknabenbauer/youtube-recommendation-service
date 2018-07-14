package de.basedefender.youtube.api.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import de.basedefender.youtube.YoutubeApiResponse;
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

    public YoutubeApiResponse getComments(String videoId) {

        videoId = videoId.equals("") ? "_-uaFU3bO1A" : videoId;

        try {

            YouTube.CommentThreads.List commentThreadsListByVideoIdRequest = super.getYouTube()
                    .commentThreads().list("snippet,replies");

            commentThreadsListByVideoIdRequest.setVideoId(videoId);

            CommentThreadListResponse response = commentThreadsListByVideoIdRequest.execute();
            return new YoutubeApiSuccess(response);

        } catch (IOException ex) {

            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.BAD_REQUEST,
                    "Failed while executing search on YouTube. Wrong search parameter? " +
                            "Check Channel ID.");
        }

    }

}
