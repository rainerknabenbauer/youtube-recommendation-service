package de.basedefender.youtube;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.util.YtChannelUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class YtChannelUtilsTest {

    private YtChannelUtils ytChannelUtils;
    private static String gotoChannelId = "UCs_tLP3AiwYKwdUHpltJPuA";

    @Before
    public void init() {
        this.ytChannelUtils = new YtChannelUtils(10L);
    }

    @Test
    public void searchVideosByChannelTest() {

        SearchListResponse response = ytChannelUtils.searchVideos(gotoChannelId);

        Assert.assertTrue(response.getItems().iterator().hasNext());
        Assert.assertEquals(10, response.getItems().size());
    }


}
