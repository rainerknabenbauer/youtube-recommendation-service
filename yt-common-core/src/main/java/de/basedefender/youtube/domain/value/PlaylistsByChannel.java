package de.basedefender.youtube.domain.value;

import de.basedefender.youtube.domain.PlaylistSearch;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Retrieve all playlists by channel ID.
 */
@Value
@EqualsAndHashCode
public class PlaylistsByChannel extends PlaylistSearch {

  private final String part;
  private final String channelId;
  private final Long maxResults;

  public PlaylistsByChannel(String channelId, Long maxResults) {
    this.part = "contentDetails";
    this.channelId = channelId;
    this.maxResults = maxResults;
  }

}
