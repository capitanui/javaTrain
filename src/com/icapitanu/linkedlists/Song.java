package com.icapitanu.linkedlists;

public class Song {
    private String songTitle;
    private int duration;

    Song(String songTitle, int duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    String getSongTitle() {
        return songTitle;
    }
}
