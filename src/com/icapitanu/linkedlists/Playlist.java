package com.icapitanu.linkedlists;

import java.util.LinkedList;

/*
* @author ionutcapitanu on 2019-11-28 
*/

class Playlist {
    private String name;
    private LinkedList<Song> playlist;

    Playlist(String name) {
        this.name = name;
        playlist = new LinkedList<>();
      }

     void addSong(Song song){
        if  (findSongByTitle(song.getSongTitle())==null)
                playlist.add(song);
     }

     Song findSongByTitle(String songTitle){
        for (Song s : playlist) {
            if (s.getSongTitle().equals(songTitle))
                 return s;
        }
        return null;
    }
    LinkedList<Song> getPlaylist() {
        return playlist;
    }
}
