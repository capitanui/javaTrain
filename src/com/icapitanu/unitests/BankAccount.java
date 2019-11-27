package com.icapitanu.unitests;


public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHEKING=1;
    public static final int SAVINGS=2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }


    //branch argument is true if the customer is performing the deposit at a branch
    //branch argument is false if customer is performing the deposit at an ATM
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    //branch argument is true if the customer is performing the withdrawal at a branch
    //branch argument is false if customer is performing the withdrawal at an ATM
    public double withdrawal(double amount, boolean branch) {
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accountType == CHEKING;
    }
    // More methods thast use firstName, lastname and perform other functions
}
