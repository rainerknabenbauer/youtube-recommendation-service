package de.basedefender.youtube;

import de.basedefender.youtube.api.YoutubeApiResponse;
import de.basedefender.youtube.api.service.CommentsService;
import de.basedefender.youtube.domain.BaseSearch;
import de.basedefender.youtube.search.CommentThreadsbyVideoSearch;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {YoutubeScraperRestApplication.class})
@RunWith(SpringRunner.class)
public class CommentsServiceTest {
  
  @Autowired
  private CommentsService commentsService;
  
  private final String videoId = "5Aw47Us-Vlw";
  
  @Test
  public void getCommentThreadIdsByVideoTest() {
    
    BaseSearch commentThreadSearch = new CommentThreadsbyVideoSearch(videoId, 5L);
    
    YoutubeApiResponse response = commentsService.getCommentThreadIdsByVideo(commentThreadSearch);
  
    System.out.println(response.getApiResponseStatus().getDetails());
    
    Assert.assertEquals(200, response.getApiResponseStatus().getHttpCode().intValue());
  }
}
