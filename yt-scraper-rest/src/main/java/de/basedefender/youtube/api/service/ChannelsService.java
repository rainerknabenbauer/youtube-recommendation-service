package de.basedefender.youtube.api.service;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.YoutubeApiResponse;
import de.basedefender.youtube.api.YoutubeApiError;
import de.basedefender.youtube.api.YoutubeApiSuccess;
import de.basedefender.youtube.domain.*;
import de.basedefender.youtube.enums.HttpStatusCode;
import de.basedefender.youtube.enums.SearchType;
import de.basedefender.youtube.search.VideosByChannelSearch;
import de.basedefender.youtube.value.ApiKey;
import de.basedefender.youtube.api.ApiResponseStatus;
import de.basedefender.youtube.search.PlaylistsByChannelSearch;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChannelsService extends AbstractYouTubeService {
  
  
  public ChannelsService(YouTube youTube, ApiKey apiKey) {
    super(youTube, apiKey);
  }
  
  public YoutubeApiResponse getPlaylistsByChannel(String channelId) {
    PlaylistsByChannelSearch playlistSearch =
        new PlaylistsByChannelSearch(channelId, getNumberOfVideosReturned());
    
    return searchChannel(playlistSearch);
    
  }
  
  /**
   * Get videos of query channel.
   * @return Videos by channel search
   */
  public YoutubeApiResponse getVideosByChannel(String channelId) {
   return null;
  }
  
  
  /**
   * Generic channel search.
   *
   * @param baseSearch Parameters for channel search
   * @return Extracted channel data
   */
  private YoutubeApiResponse searchChannel(BaseSearch baseSearch) {
    
    ChannelListResponse result;
    
    try {
      
      result = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
          request -> {
          }).setApplicationName("basedefender-yt-scraper")
          .build()
          .channels()
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
