package com.icapitanu.linkedlists;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/*
* @author ionutcapitanu on 2019-11-27 
*/
public class PlaylistApp {

    private static Scanner input = new Scanner (System.in);
    private static ArrayList<Album> albums;
    private static Playlist myPlaylist;
    private static boolean forwardIter=true;

    public static void main(String[] args) {

        boolean quit = false;

        initPlaylist();
        displayMenu();

        ListIterator<Song> songIterator = myPlaylist.getPlaylist().listIterator();

        while (!quit) {
            int choice;
            System.out.print("Press : ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {
                case 0:
                    displayMenu();
                    break;
                case 1:
                    listAlbums();
                    break;
                case 2:
                    listPlaylistSongs();
                    break;
                case 3:
                    playNextPlaylistSong(songIterator);
                    break;
                case 4:
                     playPrevPlaylistSong(songIterator);
                    break;
                case 5:
                    playCurrentPlaylistSong(songIterator);
                    break;
                case 6:
                    songIterator.remove();
                    System.out.println("Current song was removed from playlist");
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
    }

    private static void displayMenu () {
        System.out.println("\nMenu Options :");
        System.out.println("\t 0  - Display menu ");
        System.out.println("\t 1  - List albums");
        System.out.println("\t 2  - List playlist");
        System.out.println("\t 3  - Next");
        System.out.println("\t 4  - Previous");
        System.out.println("\t 5  - Re-play");
        System.out.println("\t 6 -  Remove current song from playlist");
        System.out.println("\t 7 -  Quit");
    }

    private static void initPlaylist(){
        albums = new ArrayList<>();

        //create new album and add it to the album list
        Album metallicaSM = new Album("Metallica");
        albums.add(metallicaSM);

        //create new playlist
        myPlaylist = new Playlist("MyPlaylist");

         // Create metallicaSM songs
        metallicaSM.addSong(Song.createSong("The Ecstasy of Gold", 153));
        metallicaSM.addSong(Song.createSong("The Call of Ktulu", 132));
        metallicaSM.addSong(Song.createSong("Master of Puppets", 165));
        metallicaSM.addSong(Song.createSong("Of Wolf and Man", 174));
        metallicaSM.addSong(Song.createSong("The Thing That Should Not Be"	, 109));
        metallicaSM.addSong(Song.createSong("Fuel"	, 132));
        metallicaSM.addSong(Song.createSong("The Memory Remains", 189));

        // Add all songs in album metallica to playlist
        for (Song s : albums.get(0).getSongsList()) {
             myPlaylist.addSong(s);
        }
    }

    private static void listAlbums() {
        for (int i=0; i<albums.size(); i++){
            Album currentAlbum = albums.get(i);
            ArrayList<Song> albumSongs = currentAlbum.getSongsList();
            System.out.println("\t" +(i+1) + "." + currentAlbum.getName() + " album, has the following songs :");
            for (int j=0;j<albumSongs.size();j++){
                System.out.println("\t\t" + (j+1) + ". : " + albumSongs.get(j).getSongTitle());
            }
        }
    }
    private static void listPlaylistSongs() {
        ListIterator<Song> iterator = myPlaylist.getPlaylist().listIterator();
        int index = 1;
        while (iterator.hasNext()) {
            System.out.println("\t" + index + "." + iterator.next().getSongTitle());
            index++;
        }
    }

    private static void playCurrentPlaylistSong(ListIterator<Song> songIterator) {
        if (forwardIter) {
            songIterator.previous();
            System.out.println("Re-playing " + songIterator.next().getSongTitle());
        }else {
            songIterator.next();
            System.out.println("Re-playing " + songIterator.previous().getSongTitle());
        }
    }

    private static void playNextPlaylistSong(ListIterator<Song> songIterator) {
        if (!forwardIter) {
            forwardIter = true;
            songIterator.next();
            if (songIterator.hasNext()) {
                System.out.println("Currently playing " + songIterator.next().getSongTitle());
            } else System.out.println("Reached to the end of the list! ");
        } else if (songIterator.hasNext()) {
            System.out.println("Currently playing " + songIterator.next().getSongTitle());
        } else System.out.println("Reached to the end of the list! ");
    }

    private static void playPrevPlaylistSong(ListIterator<Song> songIterator) {
       if (forwardIter) {
           forwardIter = false;
           songIterator.previous();
           if (songIterator.hasPrevious()) {
               System.out.println("Currently playing " + songIterator.previous().getSongTitle());
           } else System.out.println("Reached to the beginning of the list! ");
       } else if (songIterator.hasPrevious()) {
           System.out.println("Currently playing " + songIterator.previous().getSongTitle());
       } else System.out.println("Reached to the beginning of the list! ");
   }

}

