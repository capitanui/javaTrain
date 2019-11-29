package com.icapitanu.linkedlists;

import java.util.ArrayList;
import java.util.LinkedList;

/*
* @author ionutcapitanu on 2019-11-28 
*/
class Album {
    private String name;
    private ArrayList<Song> songsInAlbum;

    Album(String name) {
        this.name = name;
        this.songsInAlbum = new ArrayList<>() ;
    }

    // add song to album
    void addSong (Song song){
        if (getSongInAlbum(song)==null) {
            songsInAlbum.add(song);
        }
     }

    // find song in album
    private Song getSongInAlbum (Song songToSearch){
        for (Song currentSong : songsInAlbum) {
                if (currentSong.getSongTitle().equals(songToSearch.getSongTitle())) //Why object comparison returns false all the time ?currentSong.equals
                         return currentSong;
        }
        return null;
     }

    public String getName() {
        return name;
    }


    ArrayList<Song> getSongsInAlbum() {
        return songsInAlbum;
    }
}
