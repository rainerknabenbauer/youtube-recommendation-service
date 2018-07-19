package de.basedefender.youtube.api.controller;

import de.basedefender.youtube.api.YoutubeApiResponse;
import de.basedefender.youtube.api.service.SearchService;
import de.basedefender.youtube.enums.SearchType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Find metadata on YouTube",
        description = "Get your metadata here (required for extraction)")
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @ApiOperation(value = "Search for videos")
    @GetMapping("/videos/{anything}")
    public YoutubeApiResponse searchForVideos(@PathVariable String anything) {
        return this.searchService.getMetadata(anything, SearchType.VIDEO);
    }

    @ApiOperation(value = "Search for channels")
    @GetMapping("/channels/{anything}")
    public YoutubeApiResponse searchForChannels(@PathVariable String anything) {
        return this.searchService.getMetadata(anything, SearchType.CHANNEL);
    }

    @ApiOperation(value = "Search for playlists")
    @GetMapping("/playlists/{anything}")
    public YoutubeApiResponse searchForPlaylists(@PathVariable String anything) {
        return this.searchService.getMetadata(anything, SearchType.PLAYLIST);
    }
}
