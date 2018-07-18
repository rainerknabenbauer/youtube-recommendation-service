package de.basedefender.youtube.domain.value;

public class VideosByPlaylist {

    private final String part, playlistId, list;
    private final Long maxResults;

    public VideosByPlaylist(String part, String playlistId, String list, Long maxResults) {
        this.part = "";
        this.playlistId = playlistId;
        this.list = list;
        this.maxResults = maxResults;
    }
}
