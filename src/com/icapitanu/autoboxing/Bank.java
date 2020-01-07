package com.icapitanu.autoboxing;
import java.util.ArrayList;

// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Demo class should have an arraylist of Doubles (transactions)
// Demo:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions

class Bank {
    private String name;
    private ArrayList<Branch> branches;

     Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    boolean addBranch(String name) {
        if (findBranchByName(name)) return false; // Branch already exists
            else {
                    Branch newBranch = new Branch(name);
                    branches.add(newBranch);
                    return true;
                 }
     }

     private boolean findBranchByName(String branchName) {
         for (int i = 0; i < branches.size(); i++) {
             if (branches.get(i).getName().equals(branchName)) return true;
         }
         return false;
     }

     Branch getBranchByName(String branchName) {
         for (int i = 0; i < branches.size(); i++) {
              Branch checkedBranch = branches.get(i);
             if (checkedBranch.getName().equals(branchName))
                 return checkedBranch;
         }
         return null;
     }


     void listBranches() {
         for (int i=0; i<branches.size(); i++) {
             System.out.println(i+1 + ". " + branches.get(i).getName());
         }
     }


     void listBranchCustomers(String branchName, boolean includeTransactions) {
         if (findBranchByName(branchName)) {
             System.out.println("Branch " + branchName + " has the following customer list : ");
            ArrayList<Customer> branchCustomers = getBranchByName(branchName).getBranchCustomers();
            for (int i=0; i<branchCustomers.size(); i++) {
                System.out.println(i+1 + ". " + branchCustomers.get(i).getName());

                if(includeTransactions) {                                                                  // list also transactions
                    ArrayList<Double> customerTransactions = branchCustomers.get(i).getTransactions();
                    for (int j=0; j<customerTransactions.size();j++)
                        System.out.println("\t" + (j+1) + ". " + customerTransactions.get(j)); // un-boxing
                }
            }
         } else  System.out.println("Branch " + branchName + " does not exist in the bank.");
     }

}
