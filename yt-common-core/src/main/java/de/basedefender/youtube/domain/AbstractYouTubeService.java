package de.basedefender.youtube.domain;

import com.google.api.services.youtube.YouTube;
import de.basedefender.youtube.value.ApiKey;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public abstract class AbstractYouTubeService {

  @Getter
  private final YouTube youTube;

  private final ApiKey apiKey;

  @Getter
  @Value("${youtube.application.numberOfVideosReturned}")
  private Long numberOfVideosReturned;



  public String getApiKey() {
    return this.apiKey.toString();
  }
  


  //TODO String prettyPrint();


}
