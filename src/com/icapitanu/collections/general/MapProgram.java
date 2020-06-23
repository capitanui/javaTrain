package com.icapitanu.collections.general;

import java.util.HashMap;
import java.util.Map;

/*
* @author ionutcapitanu on 2020-02-11 
*/
public class MapProgram {

    public static void main(String[] args) {

      Map<String,String> languagues = new HashMap<>();
      languagues.put( "Java", "a compiled high level, object-oriented, platform independent language");
      languagues.put( "Python", " an interpreted, object-oriented, high-level, programming language");
      languagues.put("Algol", "an algorithmic language");
      languagues.put( "BASIC", "Beginners all purposeses programming language");


      System.out.println(languagues.replace("Java", "An object oriented language hard to lean"));
      for (String key : languagues.keySet()) {
             System.out.println(key + "  : " + languagues.get(key));
       }
    }


}
