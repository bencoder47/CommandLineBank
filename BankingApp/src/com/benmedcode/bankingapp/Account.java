package com.benmedcode.bankingapp;

public interface Account {
    public void deposit(double depositAmount);
    public void withdraw(double withdrawalAmount);
    public double getBalance();
    public String getAccountType();


}
