package com.icapitanu.array;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
                MyQueue queue = new MyQueue();
                queue.push('a');
                queue.push(2);
                System.out.println("Peek "  + queue.peek());
                System.out.println("Pop "  +   queue.pop());
                System.out.println("Empty "  + queue.empty());

    }

     //Valid paranthesis
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
     */

    public static boolean isValid(String s) {

        return false;
    }

    //Pascal's triangle

    public static List<List<Integer>> generate(int numRows){

           List<List<Integer>> result = new ArrayList<>();

           for (int i = 0; i < numRows; i++) {

               List<Integer> row = new ArrayList<>();

               for (int j = 0; j <= i; j++){

                   if (j == 0 || i == j){

                       row.add(1);

                   } else  row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
               }

               result.add(row);
           }
           return result;
    }



    public static int removeElement(int[] nums, int val) {
        int lastValidVal = nums.length-1; //assume last element in the array
        for (int i = lastValidVal; i >= 0; i--){
            if (nums[i] == val){
                int aux = nums[i];
                nums[i] = nums[lastValidVal];
                nums[lastValidVal] = aux;
                lastValidVal--;
            }
        }
        return lastValidVal+1;
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            int newTarget = target - nums[i];
                for(int j = i+1; j < nums.length; j++){
                     if (newTarget == nums[j]) {
                         return new int[]{i,j};
                     }
                }
            }
        return new int[0];
    }


    public static int[] twoSumBetter(int[] nums, int target) {
        HashMap<Integer,Integer> mapNums = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            if (mapNums.containsKey(newTarget)) {
                return new int[]{mapNums.get(newTarget),i};
            }
            mapNums.put(nums[i], i);
        }
        return new int[0];
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
