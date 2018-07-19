package de.basedefender.youtube.domain;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.AbstractYoutubeApiResponse;
import de.basedefender.youtube.api.YoutubeApiSuccess;
import de.basedefender.youtube.enums.HttpStatusCode;
import de.basedefender.youtube.value.ApiKey;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;

import java.io.IOException;

public class AbstractChannelService extends AbstractYouTubeService {
  
  
  public AbstractChannelService(YouTube youTube, ApiKey apiKey) {
    super(youTube, apiKey);
  }
  
  public AbstractYoutubeApiResponse executeSearch(YouTube.Search.List search) {
    // Call the API and print results.
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
