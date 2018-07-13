package de.basedefender.youtube;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.util.YtChannelUtils;
import de.basedefender.youtube.domain.domain.YoutubeApiResponse;
import de.basedefender.youtube.domain.domain.value.ApiResponseStatus;
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

        YoutubeApiResponse response = ytChannelUtils.searchVideosByChannel(gotoChannelId);

        Assert.assertTrue(response.getResponse().getItems().iterator().hasNext());
        Assert.assertEquals(10, response.getResponse().getItems().size());
    }


}
