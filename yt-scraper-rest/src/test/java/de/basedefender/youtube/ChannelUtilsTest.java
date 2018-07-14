package de.basedefender.youtube;

import de.basedefender.youtube.api.util.ChannelUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChannelUtilsTest {

    private ChannelUtils ytChannelUtils;
    private static String gotoChannelId = "UCs_tLP3AiwYKwdUHpltJPuA";

    /*
    @Before
    public void init() {
        this.ytChannelUtils = new ChannelUtils(10L);
    }

    @Test
    public void searchVideosByChannelTest() {

        YoutubeApiSuccess response = (YoutubeApiSuccess) ytChannelUtils
                .searchVideosByChannel(gotoChannelId);

        Assert.assertTrue(response.getResponse().getItems().iterator().hasNext());
        Assert.assertEquals(10, response.getResponse().getItems().size());
    }
    */

}
