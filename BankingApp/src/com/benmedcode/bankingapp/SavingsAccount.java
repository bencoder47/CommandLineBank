package com.benmedcode.bankingapp;

public class SavingsAccount implements Account {

    private final String ACCOUNT_TYPE = "SAVINGS";
    private double balance = 0.0;
    private int accountNumber;


    @Override
    public void deposit(double depositAmount) {
        this.balance += depositAmount;
    }

    @Override
    public void withdraw(double withdrawalAmount) {
        if(withdrawalAmount > this.balance)
        {
            System.out.println("Can not withdraw.");
        }
        else{
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal Successful. ");
        }


    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String getAccountType(){
        return this.ACCOUNT_TYPE;
    }

    @Override
    public String toString(){
        return " Account: " + this.ACCOUNT_TYPE + " \n Balance: " + this.balance + " \n";
    }
}
