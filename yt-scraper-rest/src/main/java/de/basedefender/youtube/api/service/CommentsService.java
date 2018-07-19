package de.basedefender.youtube.api.service;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import de.basedefender.youtube.api.YoutubeApiResponse;
import de.basedefender.youtube.api.YoutubeApiError;
import de.basedefender.youtube.api.YoutubeApiSuccess;
import de.basedefender.youtube.domain.*;
import de.basedefender.youtube.enums.HttpStatusCode;
import de.basedefender.youtube.value.ApiKey;
import de.basedefender.youtube.api.ApiListResponse;
import de.basedefender.youtube.api.ApiResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService extends AbstractYouTubeService {
  
  public CommentsService(YouTube youTube, ApiKey apiKey) {
    super(youTube, apiKey);
  }
  
  
  /**
   * 1. Get Video Id
   * 2. Get comment threads id
   * 3. Query comment with id
   * 4. Retrieve channel name
   */
  /**
   * Generic channel search.
   *
   * @param baseSearch Parameters for channel search
   * @return Extracted channel data
   */
  public YoutubeApiResponse getCommentThreadIdsByVideo(BaseSearch baseSearch) {
    
    List<String> commentThreadIds = new ArrayList<>();
    
    try {
      
      new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
          request -> {
          }).setApplicationName("basedefender-yt-scraper")
          .build()
          .commentThreads()
          .list(baseSearch.getPart())
          .setId(baseSearch.getId())  // Channel id
          .setKey(baseSearch.getApiKey())
          .setMaxResults(baseSearch.getMaxResults())
          .execute()
          .getItems()
          .forEach(item -> {
            commentThreadIds.add(item.getId());
          });
      
      return new YoutubeApiSuccess(
          new ApiListResponse(commentThreadIds));
      
    } catch (Exception ex) {
      
      return new YoutubeApiError(new ApiResponseStatus(HttpStatusCode.BAD_REQUEST));
      
    }
  }
  
  // get comment threads by video
  // videoId, part=replies
}
