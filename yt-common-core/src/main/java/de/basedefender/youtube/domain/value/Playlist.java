package de.basedefender.youtube.domain.value;

import com.google.api.client.json.GenericJson;
import lombok.Value;

@Value
public class Playlist extends GenericJson {
  private String name;
  private String id;
}
