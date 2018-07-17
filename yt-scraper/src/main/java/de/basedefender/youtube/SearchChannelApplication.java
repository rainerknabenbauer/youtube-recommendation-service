package de.basedefender.youtube;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import de.basedefender.youtube.domain.SearchType;

import java.io.IOException;

public class SearchChannelApplication {


    private static final Long NUMBER_OF_VIDEOS_RETURNED = 1L;
    private static String channelId = "UCIjw46txjW6oD4NU6FHaj_w";

    public static void main(String[] args) {

        YouTube.Search.List search = null;
        try {
            search = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
                    request -> { }).setApplicationName("SearchChannel").build()
                    .search().list("id,snippet");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        search.setKey(System.getenv("youtube.api.key.backup"));

        search.setChannelId(channelId);

        // think about .setType()
//        search.setType(SearchType.CHANNEL.toString());            //TODO what else to query

        search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

        try {
            SearchListResponse searchListResponse = search.execute();
            System.out.println(searchListResponse);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
