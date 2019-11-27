package com.icapitanu.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public  class GroceryListApp {
      private static Scanner input = new Scanner(System.in);
      private static GroceryList groceryList = new GroceryList();

      public  void run() {
            boolean quit=false;
            int choice=0;
            printInstructions();

            while (!quit) {
                 System.out.print("Enter your choice :" );
                 choice = input.nextInt();
                 input.nextLine();

                 switch (choice) {
                     case 0 :
                         printInstructions();
                         break;
                     case 1:
                         groceryList.printGroceryList();
                         break;
                     case 2:
                         addItem();
                         break;
                     case 3:
                         modifyItem();
                         break;
                     case 4 :
                         removeItem();
                         break;
                     case 5:
                         searchForItem();
                         break;
                     case 6:
                         processArrayList();
                         break;
                     case 7:
                         quit=true;
                         break;
                 }
             }
    }

    private void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0  - to print choice options");
        System.out.println("\t 1  - to print grocery list");
        System.out.println("\t 2  - to add an item to the list");
        System.out.println("\t 3  - to modify a grocery item");
        System.out.println("\t 4  - to remove a grocery item");
        System.out.println("\t 5  - to search a grocery item");
    }

    private  void addItem() {
           System.out.print("Please enter grocery item: ");
           groceryList.addGroceryItem(input.nextLine());
    }
    private  void modifyItem() {
        System.out.print("Enter item name :");
        String currentItem = input.nextLine();
        System.out.println("Enter replacement item :");
        String replacementItem = input.nextLine();
        groceryList.modifyGroceryItem(currentItem,replacementItem);
    }

    private  void removeItem(){
        System.out.print("Enter item name :");
        String item  = input.nextLine();
        groceryList.removeGroceryItem(item);
    }

    private  void searchForItem(){
        System.out.print("Enter item to look for: ");
        String searchItem = input.nextLine();
        if (groceryList.findItemS(searchItem))
            System.out.println("Found " + searchItem + " in grocery list");
        else
            System.out.println(searchItem + " not found in grocery list");
      }

    private  void processArrayList() {
          //create a new string array and copy the grocerylist Arraylist
          ArrayList<String> newArray = new ArrayList<String>(groceryList.getGroceryList());
          //convert an ArrayList to an Array
          String[] StringArray = new String[groceryList.getGroceryList().size()];
          groceryList.getGroceryList().toArray(StringArray);
          System.out.println(Arrays.toString(StringArray));
      }
}
