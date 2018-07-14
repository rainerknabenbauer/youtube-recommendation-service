package de.basedefender.youtube.api.util;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.YoutubeApiSuccess;
import de.basedefender.youtube.domain.AbstractYoutubeApiResponse;
import de.basedefender.youtube.domain.HttpStatusCode;
import de.basedefender.youtube.util.YoutubeApiResponseUtil;

import java.io.IOException;

public class SearchUtils {

    /**
     * Executes previously configured YouTube search.
     * @param search Configured Search
     * @return YouTube API response
     */
    public static AbstractYoutubeApiResponse executeSearch(YouTube.Search.List search) {
        // Call the API and print results.
        try {
            SearchListResponse searchListResponse = search.execute();

            return new YoutubeApiSuccess(searchListResponse);

        } catch (IOException ex) {

            return YoutubeApiResponseUtil.getErrorResponse(HttpStatusCode.BAD_REQUEST,
                    "Failed while executing search on YouTube. Wrong search parameter? " +
                            "Check Channel ID.");
        }
    }
}
