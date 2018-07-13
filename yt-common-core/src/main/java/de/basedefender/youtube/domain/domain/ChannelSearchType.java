package de.basedefender.youtube.domain.domain;

public enum ChannelSearchType {

    LIKES {
        public String toString() {
            return "likes";
        }
    },
    FAVORITES {
        public String toString() {
            return "favorites";
        }
    }

}
