package de.basedefender.youtube.search;

import de.basedefender.youtube.domain.PlaylistSearch;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * Retrieve all playlists by channel ID.
 */
@Value
@EqualsAndHashCode
public class PlaylistsByChannelSearch extends PlaylistSearch {

  private final String part;
  private final String id;
  private final Long maxResults;

  public PlaylistsByChannelSearch(String id, Long maxResults) {
    this.part = "contentDetails";
    this.id = id;
    this.maxResults = maxResults;
  }
  

}
