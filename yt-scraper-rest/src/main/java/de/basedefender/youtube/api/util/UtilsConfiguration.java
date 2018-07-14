package de.basedefender.youtube.api.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilsConfiguration {

    @Bean
    public ChannelUtils ytChannelUtils() {
        return new ChannelUtils();
    }

}
