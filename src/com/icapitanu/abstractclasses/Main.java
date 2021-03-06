package com.icapitanu.abstractclasses;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ShoppingList myShoppingList = new ShoppingList("My Shopping List");
        boolean quit = false;

        while (!quit) {
            printMenu();
            System.out.print("Enter your choice : " );
            int choice = input.nextInt(); input.nextLine();
            switch(choice) {
                case 0:
                    System.out.println(myShoppingList.toString());
                    break;
                case 1:
                    System.out.print("\t Enter name : ");
                    String itemName = input.nextLine();
                    System.out.print("\t Enter price : " );
                    double itemPrice = input.nextDouble();
                    ShoppingListItem newItem = ShoppingListItem.createShoppingItem(itemName,itemPrice);
                    if (myShoppingList.addItem(newItem)) System.out.println("Item succesfully added to the list.");
                        else System.out.println("An error occurred on adding item.");
                break;
                case 2:
                    removeItem(myShoppingList);
                    break;
                case 3:
                    quit=true;
                    break;
            }
        }
    }

    private static void removeItem(ShoppingList myShoppingList) {
        String itemName = "item name";
        System.out.print("\t Enter " + itemName + " to remove : ");
        String itemRem = input.nextLine();
        if (myShoppingList.removeItem(itemRem)) System.out.println("Item succesfully removed from the list.");
        else System.out.println("An error occurred on removing item.");
    }

    public static void printMenu() {
        System.out.println("\nMenu Options :");
        System.out.println("\t 0  - Print list");
        System.out.println("\t 1  - Add Item ");
        System.out.println("\t 2  - Remove Item");
        System.out.println("\t 3  - Quit");
    }
}
