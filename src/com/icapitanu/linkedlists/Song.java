package com.icapitanu.linkedlists;

class Song {
    private String songTitle;
    private int duration;

    public Song(String songTitle, int duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    private static Song createSong(String songTitle, int duration){
        return new Song(songTitle,duration);
    }
}
