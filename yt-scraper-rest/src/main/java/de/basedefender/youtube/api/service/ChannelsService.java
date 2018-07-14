package de.basedefender.youtube.api.service;

import de.basedefender.youtube.api.util.ChannelUtils;
import de.basedefender.youtube.domain.domain.YoutubeApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChannelsService {

    private final ChannelUtils ytChannelUtils;

    public YoutubeApiResponse searchVideosByChannel(String channelId) {

        //TODO Transform SearchListResponse in domain object (maybe optional signature)

        return this.ytChannelUtils.searchVideosByChannel(channelId);
    }
}
