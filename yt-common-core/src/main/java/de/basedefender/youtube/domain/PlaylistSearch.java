package de.basedefender.youtube.domain;

import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelContentDetails;
import com.google.api.services.youtube.model.ChannelListResponse;
import lombok.NoArgsConstructor;

/**
 * Encapsulates playlist searches.
 */
@NoArgsConstructor
public abstract class PlaylistSearch extends BaseSearchImpl {
  
  public ChannelContentDetails.RelatedPlaylists getPlaylistIds(ChannelListResponse response) {

    Channel channel = response.getItems().get(0);
    return channel.getContentDetails().getRelatedPlaylists();
  }

}
