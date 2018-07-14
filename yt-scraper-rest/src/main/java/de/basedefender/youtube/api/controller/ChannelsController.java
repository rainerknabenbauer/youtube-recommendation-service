package de.basedefender.youtube.api.controller;

import de.basedefender.youtube.api.service.ChannelsService;
import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.domain.HttpStatusCode;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channels")
@Api(tags = "Youtube Channels Controller")
@RequiredArgsConstructor
public class ChannelsController {

    private final ChannelsService ytChannelService;

    @GetMapping({"", "/"})
    public String getChannelId() {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }

    @GetMapping("/{channelId}")
    public YoutubeApiResponse getVideosByChannelId(@PathVariable String channelId) {
        return this.ytChannelService.searchVideos(channelId);
    }

    @GetMapping("/likes/{channelId}")
    public String getLikesByChannelId(@PathVariable String channelId) {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }

    @GetMapping("/favorites/{channelId}")
    public String getFavoritesByChannelId(@PathVariable String channelId) {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }

    @GetMapping("/watchHistory/{channelId}")
    public String getWatchHistoryByChannelId(@PathVariable String channelId) {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }


}
