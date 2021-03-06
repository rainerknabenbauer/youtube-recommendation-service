package de.basedefender.youtube.api.controller;

import de.basedefender.youtube.api.service.ChannelsService;
import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.domain.HttpStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/channels")
@Api(tags = "Extract data from channels",
        description = "Use metadata to extract information from channels")
@RequiredArgsConstructor
public class ChannelsController {

    private final ChannelsService ytChannelService;

    @ApiIgnore
    @ApiOperation(value = "Paste URL from channel and get ID back")
    @GetMapping({"", "/"})
    public String getChannelId() {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }

    @ApiOperation(value = "Extract uploaded videos from a channel")
    @GetMapping("/{channelId}")
    public YoutubeApiResponse getVideosByChannelId(@PathVariable String channelId) {
        return this.ytChannelService.searchVideos(channelId);
    }

    @ApiOperation(value = "Extract liked videos from a channel")
    @GetMapping("/likes/{channelId}")
    public String getLikesByChannelId(@PathVariable String channelId) {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }

    @ApiOperation(value = "Extract favorited videos from a channel")
    @GetMapping("/favorites/{channelId}")
    public String getFavoritesByChannelId(@PathVariable String channelId) {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }

    @ApiOperation(value = "Extract watch history from a channel")
    @GetMapping("/watchHistory/{channelId}")
    public String getWatchHistoryByChannelId(@PathVariable String channelId) {
        return HttpStatusCode.NOT_IMPLEMENTED.toString();
    }


}
