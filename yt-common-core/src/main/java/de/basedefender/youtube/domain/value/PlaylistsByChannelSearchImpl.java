package de.basedefender.youtube.domain.value;

import de.basedefender.youtube.domain.PlaylistSearchImpl;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Retrieve all playlists by channel ID.
 */
@Value
@EqualsAndHashCode
public class PlaylistsByChannelSearchImpl extends PlaylistSearchImpl {

  private final String part;
  private final String channelId;
  private final Long maxResults;

  public PlaylistsByChannelSearchImpl(String channelId, Long maxResults) {
    this.part = "contentDetails";
    this.channelId = channelId;
    this.maxResults = maxResults;
  }

}
