package com.icapitanu.linkedlists;

import java.util.ArrayList;

/*
* @author ionutcapitanu on 2019-11-28 
*/
class Album {
    private String name;
    private ArrayList<Song> songsInAlbum;

    Album(String name, ArrayList<Song> songsInAlbum) {
        this.name = name;
        this.songsInAlbum = new ArrayList<>() ;
    }

    // add song to album
    boolean addSong (Song song){
        if (getSongInAlbum(song)!=null) {
            songsInAlbum.add(song);
            return true;
        }
        return false;
     }

    // remove song from album
    boolean removeSong (Song song){
        return songsInAlbum.remove(song);
    };

    // find song in album
    private Song getSongInAlbum (Song songToSearch){
        for (Song currentSong : songsInAlbum) {
            if (currentSong.equals(songToSearch)) return currentSong;
         }
        return null;
     }
}
