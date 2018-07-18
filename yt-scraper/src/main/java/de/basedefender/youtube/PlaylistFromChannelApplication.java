package de.basedefender.youtube;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import de.basedefender.youtube.domain.value.PlaylistsByChannel;

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

    PlaylistsByChannel playlistsByChannel =
        new PlaylistsByChannel(channelId, NUMBER_OF_VIDEOS_RETURNED);

    ChannelListResponse result = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
            request -> {
            }).setApplicationName("basedefender-yt-scraper")
            .build()
            .channels()
            .list(playlistsByChannel.getPart())
            .setId(playlistsByChannel.getChannelId())  // Channel id
            .setKey(playlistsByChannel.getApiKey())
            .setMaxResults(playlistsByChannel.getMaxResults())
            .execute();

    System.out.println(PlaylistsByChannel.getPlaylistIds(result));
  }

}
