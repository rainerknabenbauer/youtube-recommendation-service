package de.basedefender.youtube;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.util.YtChannelUtils;
import de.basedefender.youtube.domain.EnvironmentVariablesNotSetException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//@RunWith(SpringRunner.class)
public class YtChannelUtilsTest {

    private YtChannelUtils ytChannelUtils;
    private static String gotoChannelId = "UCs_tLP3AiwYKwdUHpltJPuA";
    private String apiKey;

    @Before
    public void init() {
        this.ytChannelUtils = new YtChannelUtils(10L);
        setEnvironment();
    }

    @Test
    public void searchVideosTest() {
        SearchListResponse response = ytChannelUtils.searchVideos(gotoChannelId);
        Assert.assertTrue(response.getItems().iterator().hasNext());
        Assert.assertEquals(10, response.getItems().size());
    }

    /**
     * Initializes required environment variables.
     */
    private void setEnvironment() {
        try {
            this.apiKey = System.getenv("youtube.api.key");
        } catch (Exception ex) {
            throw new EnvironmentVariablesNotSetException("Environment variable 'youtube.api.key' not set.", ex);
        }
    }

}
