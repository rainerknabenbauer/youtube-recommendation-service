package de.basedefender.youtube.domain;

import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelContentDetails;
import com.google.api.services.youtube.model.ChannelListResponse;

/**
 * Encapsulates playlist searches.
 */
public abstract class PlaylistSearch extends BaseSearch {

  public static ChannelContentDetails.RelatedPlaylists getPlaylistIds(ChannelListResponse response) {

    Channel channel = response.getItems().get(0);
    return channel.getContentDetails().getRelatedPlaylists();
  }

}
