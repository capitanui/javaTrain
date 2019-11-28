package com.icapitanu.linkedlists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*
* @author ionutcapitanu on 2019-11-27 
*/
public class PlaylistApp {
    // Create a program that implements a playlist for songs
    // Create a Song class having Title and Duration for a song.

    // The program will have an Album class containing a list of songs.
    // The albums will be stored in an ArrayList

    // Songs from different albums can be added to the playlist and will appear in the list in the order
    // they are added.

    // Once the songs have been added to the playlist, create a menu of options to:-

    // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    // List the songs in the playlist
    // A song must exist in an album before it can be added to the playlist (so you can only play songs that
    // you own).

    // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    // started tracking the direction we were going.
    // As an optional extra, provide an option to remove the current song from the playlist
    private static Scanner input = new Scanner (System.in);

    private static ArrayList<Album> albums;
    private static Album myAlbum;
    private static Playlist myPlaylist;

    // List all albums
    // Add song to playlist
    // List playlist
    // Quit, Next song, Previous song, Replay current song

    public static void main(String[] args) {

        boolean forwardIter = true;
        boolean quit = false;

        initPlaylist();
        displayMenu();

        ListIterator<Song> songIterator = myPlaylist.getPlaylist().listIterator();

        while (!quit) {
            int choice=0;
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
                    if (songIterator.hasNext() && forwardIter)
                          System.out.println("Currently playing " + songIterator.next().getSongTitle());
                        else if (songIterator.hasNext()) {
                                    forwardIter = true;
                                    songIterator.next();
                                    System.out.println("Currently playing " + songIterator.next().getSongTitle());
                                } else {
                                     System.out.println("No more songs in the playlist! ");
                                     forwardIter=false;
                                        }
                        break;
                case 4:
                    if (songIterator.hasPrevious() && !forwardIter)
                             System.out.println("Currently playing " + songIterator.previous().getSongTitle());
                        else if (songIterator.hasPrevious()){
                                    forwardIter=false;
                                    songIterator.previous();
                                    System.out.println("Currently playing " + songIterator.previous().getSongTitle());
                                } else {
                                        System.out.println("Reached to the beginning of the list! ");
                                        forwardIter=true;
                                    }
                     break;
                case 5:
                    songIterator.previous();
                    System.out.println("Currently playing " + songIterator.next().getSongTitle());
                    break;
                case 6:
                    quit=true;
                    break;
            }
        }
    }

    private static void displayMenu () {
        System.out.println("\nMenu Options :");
        System.out.println("\t 0  - to display menu ");
        System.out.println("\t 1  - to list albums");
        System.out.println("\t 2  - to list playlist songs");
        System.out.println("\t 3  - to skip to next song");
        System.out.println("\t 4  - to skip to previous song");
        System.out.println("\t 5  - to replay current song ");
        System.out.println("\t 6 - quit");
    }

    private static void initPlaylist(){
        albums = new ArrayList<>();
        myAlbum = new Album("MyAlbum");
        albums.add(myAlbum);
        myPlaylist = new Playlist("MyPlaylist");
        myAlbum.addSong(Song.createSong("The Ecstasy of Gold", 153));
        myAlbum.addSong(Song.createSong("The Call of Ktulu", 132));
        myAlbum.addSong(Song.createSong("Master of Puppets", 132));
        myPlaylist.addSong(Song.createSong("The Ecstasy of Gold", 153));
        myPlaylist.addSong(Song.createSong("Master of Puppets", 132));
        myPlaylist.addSong(Song.createSong("The Call of Ktulu", 132));
    }

    private static void listAlbums() {
        for (int i=0; i<albums.size(); i++){
            Album currentAlbum = albums.get(i);
            ArrayList<Song> albumSongs = currentAlbum.getSongsInAlbum();
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

}
