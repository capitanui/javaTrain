package com.icapitanu.linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/*
* @author ionutcapitanu on 2019-11-26 
*/
public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit,"Sydney");
        addInOrder(placesToVisit,"Barcelona");
        addInOrder(placesToVisit,"Iasi");
        addInOrder(placesToVisit,"Bucuresti");
        addInOrder(placesToVisit,"Vienna");
        addInOrder(placesToVisit,"Zaragoza");


        printList(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
         }
    }

    private static boolean addInOrder(LinkedList<String> list, String newCity){
        ListIterator<String> stringListIterator = list.listIterator();
        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);

            if (comparison==0) {
                //equal strings - city already exists
            } else if (comparison > 0) {
                //should be inserted before current city
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                //already in order - do nothing
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
}
