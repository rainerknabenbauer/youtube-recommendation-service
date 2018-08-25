package de.basedefender.youtube;

import de.basedefender.youtube.api.YoutubeApiSuccess;
import de.basedefender.youtube.api.service.ChannelsService;
import de.basedefender.youtube.domain.BaseSearch;
import de.basedefender.youtube.search.CommentThreadsbyVideoSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

@SpringBootTest(classes = {YoutubeScraperRestApplication.class})
@RunWith(SpringRunner.class)
public class ChannelServiceTest {
  
  @Autowired
  private ChannelsService channelsService;
  
  private String channelId;
  
  private final String videoId = "5Aw47Us-Vlw";

  @Test
  public void getCommentThreadIdsByVideoTest() {
    
    this.channelId = System.getenv("youtube.api.key.backup");
  
    BaseSearch search = new CommentThreadsbyVideoSearch(videoId, 5L);
  
    assertThat(channelsService.getPlaylistsByChannel(channelId),
        instanceOf(YoutubeApiSuccess.class));
  }
  
  @Test
  public void searchVideosTest() {
  
    
  }

}
