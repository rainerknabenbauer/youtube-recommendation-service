package de.basedefender.youtube.domain;

import de.basedefender.youtube.exceptions.EnvironmentVariablesNotSetException;

public abstract class BaseSearch {

    private final String apiKeyEnvironment;

    public BaseSearch() {
        this.apiKeyEnvironment = "youtube.api.key.backup";
    }

    public String getApiKey() {
        try {
            return System.getenv(this.apiKeyEnvironment);
        } catch (Exception ex) {
            throw new EnvironmentVariablesNotSetException(
                    String.format("Environment variable '%s' not set.", this.apiKeyEnvironment), ex);
        }
    }

}
