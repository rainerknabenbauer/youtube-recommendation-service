package de.basedefender.youtube.domain.value.search;

import de.basedefender.youtube.domain.BaseSearchImpl;
import de.basedefender.youtube.domain.value.CommentThreadSearchImpl;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class CommentThreadsbyVideoSearch extends CommentThreadSearchImpl {
  
  private final String part;
  private final String id;
  private final Long maxResults;
  
  public CommentThreadsbyVideoSearch(String id, Long maxResults) {
    this.part = "replies";
    this.id = id;
    this.maxResults = maxResults;
  }
}
