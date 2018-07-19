package de.basedefender.youtube.value;

import lombok.Getter;
import lombok.Value;

/**
 * YouTube API key.
 */
@Value
public class ApiKey {

    private final String apiKey;

    @Override
    public String toString() {
        return apiKey;
    }
}
