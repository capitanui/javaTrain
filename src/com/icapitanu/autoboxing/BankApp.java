package com.icapitanu.autoboxing;

import java.util.Scanner;

public  class BankApp {
    private  static Scanner input = new Scanner(System.in);
    private  static Bank bank = new Bank("MyBank");

    public static void main (String[] args){
        boolean quit=false;
        int choice;
        displayMenu();

        while (!quit) {
            System.out.print("Enter your choice : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 0 :
                    displayMenu();
                    break;
                case 1:
                     bank.listBranches();
                     break;
                case 2:
                     addBranch();
                     break;
                case 3:
                     addCustomerToBranch();
                     break;
                case 4 :
                    addCustomerTransaction();
                     break;
                case 5:
                    listBranchCustomers();
                    break;
                case 6:
                    quit=true;
                    break;
            }
        }

    }
    private static void displayMenu () {
            System.out.println("\nMenu Options :");
            System.out.println("\t 0  - to print menu options");
            System.out.println("\t 1  - to list branches");
            System.out.println("\t 2  - to add a branch");
            System.out.println("\t 3  - to add a customer to a branch");
            System.out.println("\t 4  - to add transaction for a customer of a branch");
            System.out.println("\t 5  - to list customers of a particular branch");
            System.out.println("\t 6  - quit");
    }

    private static void addBranch() {
            System.out.print("\t Enter the new branch name: " );
            String branchName = input.nextLine();
            if(bank.addBranch(branchName)) System.out.println("\t Branch " + branchName + " was added succesfully");
            else System.out.println("\t An error occurred while adding branch.");
    }

    private static void addCustomerToBranch() {
            System.out.print("\t Enter branch name: ");
            String branchName = input.nextLine();
            if (bank.getBranchByName(branchName)!=null) {
                System.out.print("\t Enter customer name: ");
                String custName = input.nextLine();
                System.out.print("\t Enter initial transaction amount: ");
                double initTrans = input.nextDouble();
                input.nextLine();

                //save customer
                Customer newCustomer = Customer.createCustomer(custName,initTrans);
                bank.getBranchByName(branchName).addCustomer(newCustomer);
            } else System.out.println("\t Invalid branch provided");
    }

    private static void addCustomerTransaction() {
        System.out.print("\t Enter branch to operate on :");
        String branchName = input.nextLine();

        if (bank.getBranchByName(branchName) != null) {

            System.out.print("\t Would you like to see a list of customers for this branch ? [Y/N]");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Y")) bank.listBranchCustomers(branchName, false);
            System.out.print("\t Enter customer name : ");
            String customer = input.nextLine();

            if (bank.getBranchByName(branchName).getCustomerByName(customer) != null) {
                System.out.print("\t Enter transaction amount : ");
                double amount = input.nextDouble();
                input.nextLine();
                //save the transaction
                bank.getBranchByName(branchName).getCustomerByName(customer).addTransaction(amount);
            } else System.out.println("\t Demo " + customer + " is not a valid customer of branch " + branchName);
        } else System.out.println("\t Invalid branch provided");
    }


    private static void listBranchCustomers() {
            System.out.print("Enter branch name : ");
            String branchName = input.nextLine();
            System.out.print("\t Would you like a list of transactions for each customer to be listed as well? [Y/N]");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("Y")) bank.listBranchCustomers(branchName,true);
                else bank.listBranchCustomers(branchName,false);
    }

}
