package de.basedefender.youtube.api.controller;

import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.api.service.SearchService;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.domain.SearchType;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Find metadata on YouTube")
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/videos/{searchterm}")
    public YoutubeApiResponse searchForVideos(@PathVariable String searchterm) {
        return this.searchService.getMetadata(searchterm, SearchType.VIDEO);
    }

    @GetMapping("/channels/{searchterm}")
    public YoutubeApiResponse searchForChannels(@PathVariable String searchterm) {
        return this.searchService.getMetadata(searchterm, SearchType.CHANNEL);
    }

    @GetMapping("/playlists/{searchterm}")
    public YoutubeApiResponse searchForPlaylists(@PathVariable String searchterm) {
        return this.searchService.getMetadata(searchterm, SearchType.PLAYLIST);
    }
}
