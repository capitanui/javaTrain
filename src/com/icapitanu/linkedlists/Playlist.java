package com.icapitanu.linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/*
* @author ionutcapitanu on 2019-11-28 
*/
class Playlist {
    private String name;
    private LinkedList<Song> playlist;

    public Playlist(String name) {
        this.name = name;
        playlist = new LinkedList<>();
      }

     void addSong(Song song){
        if (!(findSongByTitle(song.getSongTitle())))
                playlist.add(song);
    }

    private boolean findSongByTitle(String songTitle){
        for (Song s : playlist) {
            if (s.getSongTitle().equals(songTitle))
                 return true;
        }
        return false;
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }
}
