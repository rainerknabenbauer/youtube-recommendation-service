package de.basedefender.youtube.api.service;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import de.basedefender.youtube.domain.value.ApiKey;
import de.basedefender.youtube.exceptions.EnvironmentVariablesNotSetException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YoutubeServiceConfiguration {


    @Value("${youTube.application.name}")
    private String applicationName;

    @Value("${environment.youtube.api.key}")
    private String apiKeyEnvironment;

    @Bean
    public YouTube youTube() {
        return new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
                request -> { }).setApplicationName(this.applicationName).build();
    }

    @Bean
    public ApiKey apiKey() {
        try {
            return new ApiKey(System.getenv(this.apiKeyEnvironment));
        } catch (Exception ex) {
            throw new EnvironmentVariablesNotSetException(
                    String.format("Environment variable '%s' not set.", this.apiKeyEnvironment), ex);
        }
    }
}
