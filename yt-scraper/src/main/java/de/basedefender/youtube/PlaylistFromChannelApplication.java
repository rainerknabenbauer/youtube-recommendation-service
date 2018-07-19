package de.basedefender.youtube;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import de.basedefender.youtube.domain.value.search.PlaylistsByChannelSearch;

public class PlaylistFromChannelApplication {

  private static YouTube youTube;
  private static final String apiKey;
  private static final Long NUMBER_OF_VIDEOS_RETURNED = 1L;

  static {
    apiKey = System.getenv("youtube.api.key");
    System.out.println(apiKey);
  }

  public static void main(String[] args) throws Exception {

    String channelId = "UCbcTU0KiCbjDEKttI9QjOPw";

    PlaylistsByChannelSearch playlistsByChannelSearch =
        new PlaylistsByChannelSearch(channelId, NUMBER_OF_VIDEOS_RETURNED);

    ChannelListResponse result = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
            request -> {
            }).setApplicationName("basedefender-yt-scraper")
            .build()
            .channels()
            .list(playlistsByChannelSearch.getPart())
            .setId(playlistsByChannelSearch.getId())  // Channel id
            .setKey(playlistsByChannelSearch.getApiKey())
            .setMaxResults(playlistsByChannelSearch.getMaxResults())
            .execute();

    //System.out.println(PlaylistsByChannelSearch.getPlaylistIds(result));
  }

}
