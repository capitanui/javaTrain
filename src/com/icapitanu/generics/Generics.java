package com.icapitanu.generics;

import java.util.ArrayList;

/*
* @author ionutcapitanu on 2019-12-20 
*/
public class Generics {


    public static void main(String[] args) {

        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);

        printDoubled(items);
    }

    private static void printDoubled(ArrayList<Integer> n) {
        for (int i : n) {
            System.out.println( i * 2);
        }
    }
}
