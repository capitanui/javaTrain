package com.icapitanu.generics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
* @author ionutcapitanu on 2020-01-14 
*/
public class League<E extends Team>{

     private String name;
     private LinkedList<E> leaqueTeams = new LinkedList<>();

     League(String name) {
          this.name = name;
     }

     void addTeam(E e){
         leaqueTeams.add(e);
     }

     public void printLeague() {
          System.out.println("\n" +  getName() + ":" );
          Collections.sort(leaqueTeams,Collections.reverseOrder());
          System.out.println("Team  |   Points");
          for (Team t : leaqueTeams) {
               System.out.println(t.getName() + "  " + t.getPoints());
          }
     }

     public String getName() {
          return name;
     }
}
