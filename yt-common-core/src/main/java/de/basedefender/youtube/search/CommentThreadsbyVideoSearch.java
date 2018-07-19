package de.basedefender.youtube.search;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class CommentThreadsbyVideoSearch extends CommentThreadSearch {
  
  private final String part;
  private final String id;
  private final Long maxResults;
  
  public CommentThreadsbyVideoSearch(String id, Long maxResults) {
    this.part = "replies";
    this.id = id;
    this.maxResults = maxResults;
  }
}
