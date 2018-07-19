package de.basedefender.youtube.api.service;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.domain.*;
import de.basedefender.youtube.domain.value.ApiKey;
import de.basedefender.youtube.domain.value.ApiResponseStatus;
import de.basedefender.youtube.domain.value.search.PlaylistsByChannelSearch;
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
  
  public YoutubeApiResponse getPlaylistsByChannel(String channelId) {
    PlaylistsByChannelSearch playlistSearch =
        new PlaylistsByChannelSearch(channelId, getNumberOfVideosReturned());
    
    return searchChannel(playlistSearch);
    
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
