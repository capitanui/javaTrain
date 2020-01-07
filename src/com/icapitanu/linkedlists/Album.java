package com.icapitanu.linkedlists;

import java.util.ArrayList;

/*
* @author ionutcapitanu on 2019-11-28 
*/
class Album {
    private String name;
    private SongList songsList;

    Album(String name) {
        this.name = name;
        songsList = new SongList();
    }

    // find song in album
    public void addSong(Song song){
        songsList.addSong(song);
    }

    public String getName() {
        return name;
    }

    ArrayList<Song> getSongsList() {
        return songsList.songsInAlbum;
    }

    private class SongList {
        private ArrayList<Song> songsInAlbum;

        SongList() {
            this.songsInAlbum = new ArrayList<>();
        }

        // add song to album
        private void addSong (Song song){
            if (getSongInAlbum(song)==null) {
                songsInAlbum.add(song);
            }
        }

        private Song getSongInAlbum (Song songToSearch){
            for (Song currentSong : songsInAlbum) {
                if (currentSong.getSongTitle().equals(songToSearch.getSongTitle())) //Why object comparison returns false all the time ?currentSong.equals
                    return currentSong;
            }
            return null;
        }

    }
}
