package com.icapitanu.collections.general;

import java.util.HashMap;
import java.util.Map;

/*
* @author ionutcapitanu on 2020-03-02 
*/
public final class Location {
    private final int id;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int id, String description) {
        this.id = id;
        this.description = description;
        this.exits = new HashMap<>();
        this.addExit( "Q",0);
    }

    public void addExit(String direction, Integer location){
        exits.put( direction,location);
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exits);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
