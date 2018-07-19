package de.basedefender.youtube.domain;

import com.google.api.client.json.GenericJson;
import com.google.api.services.youtube.model.ChannelListResponse;
import de.basedefender.youtube.value.Playlist;
import lombok.Value;

import java.util.ArrayList;

/**
 * Accummulates playlists.
 */
@Value
public class Playlists extends GenericJson {

  private ArrayList<Playlist> playlists;
  
  public Playlists(ChannelListResponse response) {
  
    this.playlists = new ArrayList<>();
  
    response.forEach((name, playlist) -> {
      this.playlists.add(new Playlist(name, playlist.toString()));
    });
    
  }
  
  public ArrayList<Playlist> getPlaylists() {
    return this.playlists;
  }

}
