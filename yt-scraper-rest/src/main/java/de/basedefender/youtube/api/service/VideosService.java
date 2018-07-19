package de.basedefender.youtube.api.service;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.VideoListResponse;
import de.basedefender.youtube.api.YoutubeApiResponse;
import de.basedefender.youtube.api.YoutubeApiError;
import de.basedefender.youtube.api.YoutubeApiSuccess;
import de.basedefender.youtube.domain.*;
import de.basedefender.youtube.enums.HttpStatusCode;
import de.basedefender.youtube.value.ApiKey;
import de.basedefender.youtube.api.ApiResponseStatus;
import de.basedefender.youtube.search.CommentThreadsbyVideoSearch;
import org.springframework.stereotype.Service;

@Service
public class VideosService extends AbstractYouTubeService {
  
  private final CommentsService commentsService;
  
  public VideosService(YouTube youTube, ApiKey apiKey, CommentsService commentsService) {
    super(youTube, apiKey);
    this.commentsService = commentsService;
  }
  
  /**
   * Get comments for a specific video.
   *
   * @param videoId YouTube Video ID
   * @return Comments
   */
  public YoutubeApiResponse getComments(String videoId) {
  
    CommentThreadsbyVideoSearch threadSearch =
        new CommentThreadsbyVideoSearch(videoId, getNumberOfVideosReturned());
    
    YoutubeApiSuccess apiResponse =
        (YoutubeApiSuccess) this.commentsService.getCommentThreadIdsByVideo(threadSearch);
    
    //TODO Retrieve all comments, extract commentator channels
    
    
    
    /**
     * 1. Get Video Id
     * 2. Get comment threads id
     * 3. Query comment with id
     * 4. Retrieve channel name
     */
    
    return null;
  }
  
  /**
   * Generic video search.
   *
   * @param baseSearch Parameters for video search
   * @return Extracted video data
   */
  private YoutubeApiResponse searchVideo(BaseSearch baseSearch) {
  
    /**
     * Videos are quite complex. Maybe get viewer count ... ratings ... others
     *
     * "statistics": {
     "viewCount": unsigned long,
     "likeCount": unsigned long,
     "dislikeCount": unsigned long,
     "favoriteCount": unsigned long,
     "commentCount": unsigned long
     }
     *
     */
  
    VideoListResponse result;
    
    try {
      
      result = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
          request -> {
          }).setApplicationName("basedefender-yt-scraper")
          .build()
          .videos()
          .list(baseSearch.getPart())
          .setId(baseSearch.getId())  // Channel id
          .setKey(baseSearch.getApiKey())
          .setMaxResults(baseSearch.getMaxResults())
          .execute();
      
      return new YoutubeApiSuccess(result);
      
    } catch (Exception ex) {
      
      return new YoutubeApiError(new ApiResponseStatus(HttpStatusCode.BAD_REQUEST));
      
    }
  }
}
