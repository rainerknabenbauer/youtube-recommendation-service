package de.basedefender.youtube;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequest;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import de.basedefender.youtube.domain.SearchType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class FindChannelIDApplication {

    private YouTube youTube;
    private YouTubeRequest youTubeRequest;
    private static final String apiKey = "AIzaSyDbVzRmlKdIEhwE7_FoxoRas_gp3p6cbpE";
    private static final Long NUMBER_OF_VIDEOS_RETURNED = 1L;

    private FindChannelIDApplication() throws Exception {

        this.youTube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {
                // no-op override
            }
        }).setApplicationName("basedefender-yt-scraper").build();

        SearchListResponse searchResponse = search(getInputQuery(), SearchType.VIDEO);

        List<SearchResult> searchResultList = searchResponse.getItems();
        if (searchResultList != null) {
            printSearchResults(searchResultList.iterator());
        }
    }

    /*
     * Prints out all results in the Iterator. For each result, print the
     * title, video ID, and thumbnail.
     *
     * @param iteratorSearchResults Iterator of SearchResults to print
     *
     * @param query Search query (String)
     */
    @SuppressWarnings("Duplicates")
    private void printSearchResults(Iterator<SearchResult> iteratorSearchResults) throws Exception {

        System.out.println("\n=============================================================");
        System.out.println(
                "   First " + NUMBER_OF_VIDEOS_RETURNED + " videos for search.");
        System.out.println("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            System.out.println(" There aren't any results for your query.");
        }

        while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();

            String channelId = singleVideo.getSnippet().getChannelId();
            String channelTitle = singleVideo.getSnippet().getChannelTitle();
            // String channelName = singleVideo.getSnippet().getDetails();   null
            // String channelName = singleVideo.getKind();

            ResourceId rId = singleVideo.getId();


            // Confirm that the result represents a video. Otherwise, the
            // item will not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {

                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
                System.out.println(" Channel name: " + channelId);
                System.out.println(" Channel title: " + channelTitle);

                System.out.println("\n-------------------------------------------------------------\n");

                getAllVideosFromChannel(channelId);
            }
        }
    }

    private SearchListResponse search(String queryTerm, SearchType searchType) throws Exception {

        // Define the API request for retrieving search results.
        YouTube.Search.List search = this.youTube.search().list("id,snippet");

        // Set your developer key from the {{ Google Cloud Console }} for
        // non-authenticated requests. See:
        // {{ https://cloud.google.com/console }}
        search.setKey(apiKey);
        if (searchType.equals(SearchType.CHANNEL)) {
            search.setChannelId(queryTerm);
        } else {
            search.setQ(queryTerm);
        }

        // Restrict the search results to only include videos. See:
        // https://developers.google.com/youtube/v3/docs/search/list#type
        search.setType(SearchType.VIDEO.toString());

        // To increase efficiency, only retrieve the fields that the
        // application uses.
        //search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");  //TODO Use Filter
        search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

        // Call the API and print results.
        return search.execute();

    }

    private void getAllVideosFromChannel(String channelId) throws Exception {

        SearchListResponse searchResponse = search(channelId, SearchType.CHANNEL);

        List<SearchResult> searchResultList = searchResponse.getItems();
        if (searchResultList != null) {
            printVideosFromChannel(searchResultList.iterator());
        }
    }

    private void printVideosFromChannel(Iterator<SearchResult> iteratorSearchResults) {
           while (iteratorSearchResults.hasNext()) {
               SearchResult channelVideos = iteratorSearchResults.next();

               //TODO order by view count
               System.out.println("getVideosFromChannel: " +
                       channelVideos.getSnippet().getTitle());
           }
    }

    /*
     * Prompt the user to enter a query term and return the user-specified term.
     */
    @SuppressWarnings("Duplicates")
    private String getInputQuery() throws IOException {

        String inputQuery = "";

        System.out.print("Search for video title: ");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        inputQuery = bReader.readLine();

        if (inputQuery.length() < 1) {
            // Use the string "YouTube Developers Live" as a default.
            inputQuery = "GoTo Conference";
        }
        return inputQuery;
    }

    public static void main(String[] args) throws Exception {
        new FindChannelIDApplication();
    }
}
