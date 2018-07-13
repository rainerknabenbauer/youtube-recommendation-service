package de.basedefender.youtube.api.controller;

import de.basedefender.youtube.api.service.YtVideoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
@Api(tags = "Youtube Videos Controller")
@RequiredArgsConstructor
public class YtVideoConroller {

    private final YtVideoService ytVideoService;

    @Value("${messages.notyetimplemented}")
    private String implementationMessage;

    @GetMapping("/comments/{videoId}")
    public String getCommentsByVideoId(@PathVariable String videoId) {
        return implementationMessage;
    }


}
