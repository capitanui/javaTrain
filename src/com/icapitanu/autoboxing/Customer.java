package com.icapitanu.autoboxing;

import java.util.ArrayList;

public  class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name,double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialTransaction);
     }

    public boolean addTransaction(double transAmount){
        if (transAmount > 0) {
            transactions.add(Double.valueOf(transAmount)); //Validate transaction amount
         }
            else return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public static Customer createCustomer(String name,Double initialTransaction){
        return new Customer(name,initialTransaction);
    }
}
