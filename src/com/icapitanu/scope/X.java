package com.icapitanu.scope;

import java.util.Scanner;

/*
* @author ionutcapitanu on 2020-01-22 
*/
class X {
    private Scanner x = new Scanner(System.in);

    void printTimesTable(int inX) {
         for (int x=1;x<=12;x++){
            System.out.println(x + " * " + inX + " = " + x*inX);
        }
    }
    int getInX() {
        int x = 0;
        System.out.println("Enter a number: ");
        x = this.x.nextInt();
        this.x.nextLine();
        return x;
    }


}

class Main {
            public static void main(String[]args){
                X x = new X();
                x.printTimesTable(x.getInX());
               }


}