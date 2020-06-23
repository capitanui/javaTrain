package com.icapitanu.collections.general;
/*
* @author ionutcapitanu on 2020-01-27
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in );

        locations.put( 0, new Location( 0, "You are sitting in front  of a computer learning Java" ) );
        locations.put( 1, new Location( 1, "You are standing at the end of a road before a small brick building" ) );
        locations.put( 2, new Location( 2, "You are at the top of a hill" ) );
        locations.put( 3, new Location( 3, "You are inside a building, a well house for a small spring" ) );
        locations.put( 4, new Location( 4, "You are in a valley behind a stream" ) );
        locations.put( 5, new Location( 5, "You are in the forest" ) );

        locations.get( 1 ).addExit( "W", 2 );
        locations.get( 1 ).addExit( "E", 3 );
        locations.get( 1 ).addExit( "S", 4 );
        locations.get( 1 ).addExit( "N", 5 );

        locations.get( 2 ).addExit( "N", 5 );

        locations.get( 3 ).addExit( "W", 1 );

        locations.get( 4 ).addExit( "N", 1 );
        locations.get( 4 ).addExit( "W", 2 );

        locations.get( 5 ).addExit( "S", 1 );
        locations.get( 5 ).addExit( "W", 2 );

        int loc = 1;
        while (true) {
            System.out.println( locations.get( loc ).getDescription() );
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get( loc ).getExits();
            System.out.println("Available exists are " + exits.keySet().toString());

            // map directions to words
            Map<String, String> directions = new HashMap<>();
            directions.put( "WEST", "W" );
            directions.put( "EAST", "E" );
            directions.put( "SOUTH", "S" );
            directions.put( "NORTH", "N" );
            directions.put( "QUIT", "Q" );

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split( " ");
                for (String possibleDirection : words) {
                    if (directions.containsKey( possibleDirection)) {
                        direction = directions.get(possibleDirection);
                        break;
                    }
                }

            }

            for (String exit : exits.keySet()) {
                if (direction.equals( exit))
                    loc = exits.get( exit );
            }
        }
    }
}
