package com.icapitanu.unitests;

import static org.junit.Assert.*;

import org.junit.Test;

public  class BankAccountTest {


    @org.junit.Test
    public void deposit() {
     // set-up
     BankAccount account = new BankAccount("Ion","Capitanu",1000, BankAccount.CHEKING);
     double balance = account.deposit(200,true);
     assertEquals(1200,balance,0);
    }

    @org.junit.Test
    public void getBalanceAfterWithdrawl() {
        // set-up
        BankAccount account = new BankAccount("Ion","Capitanu",1000, BankAccount.CHEKING);
        double balance = account.withdrawal(200,true);
        assertEquals(800,account.getBalance(),0);
    }

    @org.junit.Test
    public void getBalanceAfterDeposit() {
        // set-up
        BankAccount account = new BankAccount("Ion","Capitanu",1000, BankAccount.CHEKING);
        double balance = account.deposit(200,true);
        assertEquals(1200,account.getBalance(),0);
    }

    @Test
    public void isCheckingAccount () {
        BankAccount account = new BankAccount("Ion","Capitanu",1000, BankAccount.SAVINGS);
        assertTrue("The account is not a checking account",account.isChecking());
    }
}