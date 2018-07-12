package de.basedefender.youtube.domain;

public enum SearchType {
    CHANNEL {
        public String toString() {
            return "channel";
        }
    },
    VIDEO {
        public String toString() {
            return "video";
        }
    },
    PLAYLIST {
        public String toString() {
            return "playlist";
        }
    };
}
