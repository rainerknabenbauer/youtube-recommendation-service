package de.basedefender.youtube.api.service;

import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.api.util.YtChannelUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class YtChannelService {

    private final YtChannelUtils ytChannelUtils;

    public SearchListResponse searchVideosByChannel(String channelId) {

        //TODO Transform SearchListResponse in domain object (maybe optional signature)

        return ytChannelUtils.searchVideos(channelId);
    }
}
