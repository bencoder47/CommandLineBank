package com.benmedcode.bankingapp;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Account> Accounts = new ArrayList<>();

    private int ID;
    private String firstName;
    private String lastName;
    private String username;
    private int AccountIndex;
    private int PIN;

    public Customer(String firstName, String lastName, String username, int PIN) {
        this.Accounts.add(new CheckingAccount());
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.PIN = PIN;
    }

    public void makeDeposit(double amountToDeposit) {
        this.Accounts.get(getAccountIndex()).deposit(amountToDeposit);
    }

    public void makeWithdrawal(double amountToWithdraw) {
        this.Accounts.get(getAccountIndex()).withdraw(amountToWithdraw);
    }

    public void CloseAccount() {
        this.Accounts.remove(getAccountIndex());
        System.out.println("Account Removed");
    }

    public void TransferToDifferentAccount()
    {

    }





    public String getAccounts() {
        return this.Accounts.toString();
    }

    public void setAccounts(ArrayList<Account> accounts) {
        Accounts = accounts;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getAccountIndex() {
        return AccountIndex;
    }

    public void setAccountIndex(int accountIndex) {
        AccountIndex = accountIndex;
    }

    @Override
    public String toString()
    {
        return "name: "  + this.firstName + " " + this.lastName + "\n user: " + this.username + "\n Accounts: \n" + this.getAccounts();
    }


}
