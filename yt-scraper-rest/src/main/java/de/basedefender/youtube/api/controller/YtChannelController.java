package de.basedefender.youtube.api.controller;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.service.YtChannelService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channels")
@Api(tags = "Youtube Channels Controller")
@RequiredArgsConstructor
public class YtChannelController {

    private final YtChannelService ytChannelService;

    @Value("${messages.notyetimplemented}")
    private String implementationMessage;

    @GetMapping({"", "/"})
    public String getChannelId() {
        return this.implementationMessage;
    }

    @GetMapping("/{channelId}")
    public SearchListResponse getVideosByChannelId(@PathVariable String channelId) {
        return this.ytChannelService.searchVideosByChannel(channelId);
    }

    @GetMapping("/likes/{channelId}")
    public String getLikesByChannelId(@PathVariable String channelId) {
        return this.implementationMessage;
    }

    @GetMapping("/favorites/{channelId}")
    public String getFavoritesByChannelId(@PathVariable String channelId) {
        return this.implementationMessage;
    }

    @GetMapping("/watchHistory/{channelId}")
    public String getWatchHistoryByChannelId(@PathVariable String channelId) {
        return this.implementationMessage;
    }


}
