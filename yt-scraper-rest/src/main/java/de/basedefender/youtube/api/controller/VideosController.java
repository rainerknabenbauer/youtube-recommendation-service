package de.basedefender.youtube.api.controller;

import de.basedefender.youtube.YoutubeApiResponse;
import de.basedefender.youtube.api.service.VideosService;
import de.basedefender.youtube.domain.HttpStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
@Api(tags = "Extract data from videos",
        description = "Use metadata to extract information from videos")
@RequiredArgsConstructor
public class VideosController {

    private final VideosService videosService;

    @ApiOperation(value = "Extract comments from a video")
    @GetMapping("/comments/{videoId}")
    public YoutubeApiResponse getCommentsByVideoId(@PathVariable String videoId) {
        return this.videosService.getComments(videoId);
    }


}
