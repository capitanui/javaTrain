package com.icapitanu.linkedlists;

import java.util.Iterator;
import java.util.LinkedList;

import sun.awt.image.ImageWatched;

/*
* @author ionutcapitanu on 2019-11-26 
*/
public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Barcelona");
        placesToVisit.add("Iasi");
        placesToVisit.add("Bucuresti");
        placesToVisit.add("Vienna");

        printList(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        for (int i1=0;i1<linkedList.size();i1++){
            linkedList.get(i1);
            System.out.println(linkedList.get(i1));
        }
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
         }
    }
}
