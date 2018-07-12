package de.basedefender.youtube.api.controller;

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
@Api(tags = "Youtube Channel Controller")
public class YtChannelController {

    @Autowired
    public YtChannelController(YtChannelService ytChannelService) {
        this.ytChannelService = ytChannelService;
    }

    private final YtChannelService ytChannelService;

    @Value("${messages.notyetimplemented}")
    private String implementationMessage;

    @GetMapping({"", "/"})
    public String getChannelId() {
        return implementationMessage;
    }

    @GetMapping("/{channelId}")
    public String getVideosByChannelId(@PathVariable String channelId) {
        return implementationMessage;
    }

    @GetMapping("/likes/{channelId}")
    public String getLikesByChannelId(@PathVariable String channelId) {
        return implementationMessage;
    }

    @GetMapping("/favorites/{channelId}")
    public String getFavoritesByChannelId(@PathVariable String channelId) {
        return implementationMessage;
    }

    @GetMapping("/watchHistory/{channelId}")
    public String getWatchHistoryByChannelId(@PathVariable String channelId) {
        return implementationMessage;
    }


}
