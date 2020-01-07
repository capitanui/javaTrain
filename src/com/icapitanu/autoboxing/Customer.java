package com.icapitanu.autoboxing;

import java.util.ArrayList;

 class Customer {
    private String name;
    private ArrayList<Double> transactions;

     private Customer(String name,double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialTransaction);
     }

     void addTransaction(double transAmount){
        if (transAmount > 0) {
            transactions.add(transAmount); //Validate transaction amount
         }
    }


    String getName() {
        return name;
    }

    ArrayList<Double> getTransactions() {
        return transactions;
    }

    static Customer createCustomer(String name,Double initialTransaction){
        return new Customer(name,initialTransaction);
    }
}
