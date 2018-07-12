package de.basedefender.youtube.api;

import de.basedefender.youtube.api.util.YtChannelUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YtUtilsConfiguration {

    @Bean
    public YtChannelUtils ytChannelUtils() {
        return new YtChannelUtils();
    }

}
