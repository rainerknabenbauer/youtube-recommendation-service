package de.basedefender.youtube.api;

import com.google.api.client.json.GenericJson;
import lombok.Value;

import java.util.List;

@Value
public class ApiListResponse extends GenericJson {
  
  private final List<String> list;
  
  public ApiListResponse(List<String> list) {
    this.list = list;
  }
  
  
}
