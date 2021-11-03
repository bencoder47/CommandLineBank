package com.benmedcode.bankingapp;

public class CheckingAccount implements Account{


    private final String ACCOUNT_TYPE = "CHECKING";
    private double balance = 0.0;
    private int accountNumber;

    public CheckingAccount() {
        System.out.println("Creating a new checking account");
    }

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
        return "Account: " + ACCOUNT_TYPE + " \n Balance: " + balance + " \n";
    }
}
