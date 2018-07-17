package de.basedefender.youtube.domain;

public enum PlaylistSearchType {

    LIKES {
        public String toString() {
            return "likes";
        }
    },
    FAVORITES {
        public String toString() {
            return "favorites";
        }
    },
    WATCHHISTORY {
        public String toString() {
            return "watchHistory";
        }
    }
}
