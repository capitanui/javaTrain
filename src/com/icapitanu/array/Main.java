package com.icapitanu.array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.

// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main (String[] args) {
        System.out.println("Enter number of elements:");
        int size = input.nextInt();
        int[] myArray = getIntegers(size);
        System.out.println("Print sorted array");
        sortArray(myArray);
        printArray(myArray);
        System.out.println("Minium in array is : " + findMin(myArray));
        input.close();
        System.out.println("Reversed sorted array : ");
        reverseArray(myArray);
        printArray(myArray);
    }

    public static int[] getIntegers(int size) {
        int[] intArray = new int[size];
        System.out.println("Enter array elements : ");
        for (int i=0; i<size; i++) {
            intArray[i] = input.nextInt();
        }
        input.close();
        return intArray;
    }

    public static void printArray(int[] arrayToPrint){
        System.out.println(Arrays.toString(arrayToPrint));
    }

    public static void sortArray(int[] arrayToSort) {
        int intermed = 0;
         for (int i=0; i<arrayToSort.length-1; i++)
         {
             if (arrayToSort[i] < arrayToSort[i+1]) {
                intermed =  arrayToSort[i];
                arrayToSort[i] = arrayToSort[i+1];
                arrayToSort[i+1] = intermed;
                sortArray(arrayToSort);
             }
        }
    }

    public static int findMin(int[] array) {
        int min=0;
         for (int i=0;i<array.length;i++){
            if (i==0) min=array[i];
               else if (array[i] < min) min=array[i];
        }
         return min;
    }

    public static void reverseArray(int[] array){
        int temp;
        for (int i=0;i<array.length;i++){
            if (i<array.length/2) {
                temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
        }
    }

}
