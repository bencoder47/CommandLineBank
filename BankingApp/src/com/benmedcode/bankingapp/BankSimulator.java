package com.benmedcode.bankingapp;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class BankSimulator {
    private ArrayList<Customer> customers = new ArrayList<>();
    private int currentCustomerIndex;
    private String customerLoggedIn;
    private int PIN;
    private boolean keepAppOpen = true;
    Scanner sc = new Scanner(System.in);
    //Add a date and time.
    //Use the current pin to know which customer you are accessing.


    public BankSimulator() {
        System.out.println(" ---------------------BMC Bank Simulator--------------------- \n");
        while (keepAppOpen) {
            customerMenu();
        }
    }

    /*
    customerLogin: Checks if a customer exists, and accesses it.
     */
    public boolean customerLogin(String username, int PIN)
    {
       for(Customer cust : customers)
       {
           if(cust.getUsername() == username && cust.getPIN() != PIN)
           {
               System.out.println("Incorrect Password");
           }
           else if(cust.getUsername().equals(username)  && cust.getPIN() == PIN)
           {

               System.out.println("\n\nSuccessfully Logged In");
               setCurrentCustomerIndex(customers.indexOf(cust)); //set the current customer to the logged in
               return true;
           }
           else{
               System.out.println("We're sorry the customer could not be found. ");
           }

       }
       return false;
    }

    /*
    customerMenu: display the customers accounts
     */

    public void customerMenu(){
        System.out.println(" ------------------------------------------------------------ \n");
        System.out.println("Menu: \n");
        System.out.println("(1). Sign into your BMC Account.");
        System.out.println("(2). Create a BMC Account.");
        System.out.println("(3). Exit.");
        System.out.println(" ------------------------------------------------------------ \n");
        System.out.print("Select: ");
        int menuItem = sc.nextInt();
        sc.nextLine();
        System.out.println();

        System.out.println("Current Selection: "  + menuItem);
        if(menuItem == 1)
        {
            System.out.println("User: ");
            String user = sc.nextLine();
            System.out.println("PIN: ");
            int pin = sc.nextInt();
            sc.nextLine();

            if(customerLogin(user, pin))
            {
                System.out.println(this.customers.get(getCurrentCustomerIndex()).toString());
                customerAccountMenu();
            }

        }
        else if(menuItem == 2)
        {
            System.out.println("Welcome to BMC");
            System.out.println("First name: ");
            String firstName = sc.nextLine();
            System.out.println("Last Name: ");
            String lastName = sc.nextLine();

            System.out.println("Select a username: ");
            String username = sc.nextLine();

            //Check if username already exists
            System.out.println("Create your PIN: ");
            int PIN = sc.nextInt();
            sc.nextLine();

            addCustomer(new Customer(firstName, lastName, username, PIN));

            System.out.println("Customer successfully created.");
        }
        else{
            this.keepAppOpen = false;
            System.out.println("Thanks for banking with BMC.");
            System.out.println("----------------------------");
        }
    }

    /*
    addCustomer: add a customer to the bank
     */
    public void addCustomer(Customer c)
    {
        this.customers.add(c);
    }

    /*
    deleteCustomer: delete a customer from the bank
     */
    public void deleteCustomer(Customer c)
    {
        this.customers.remove(c);
    }

    public int getCurrentCustomerIndex() {
        return currentCustomerIndex;
    }

    public void setCurrentCustomerIndex(int currentCustomerIndex) {
        this.currentCustomerIndex = currentCustomerIndex;
    }

    public void customerAccountMenu()
    {
        System.out.println("Account Menu()\n 1. Deposit \n 2. Withdraw \n 3. Close Your Account");
        System.out.print("Select: ");
        int menuOption = sc.nextInt();
        sc.nextLine();

        //If the menuOption entered does not match, prompt again.
        while(menuOption !=1   && menuOption !=2 && menuOption !=3 )
        {
            System.out.println("Please select from out menu. ");
            menuOption = sc.nextInt();
            sc.nextLine();
        }

        if(menuOption == 1)
        {
            System.out.println("Which account would you like to deposit your funds?");
            System.out.println("(1) Checkings or (2) Savings");
            int option = sc.nextInt();
            sc.nextLine();

            System.out.print("Amount: ");

            double amount = sc.nextDouble();
            sc.nextLine();

                if(option == 1)
                {
                    customers.get(getCurrentCustomerIndex()).makeCheckingsDeposit(amount);
                }
                else if(option == 2){
                    customers.get(getCurrentCustomerIndex()).makeSavingsDeposit(amount);
                }
                else{
                    System.out.println("We are sorry please try again. ");
                }
        }
        else if(menuOption == 2)
        {
            System.out.println("Which account will you be withdrawing from?");
            System.out.println("(1) Checkings or (2) Savings");
            int option = sc.nextInt();
            sc.nextLine();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            if(option == 1)
            {
                customers.get(getCurrentCustomerIndex()).makeCheckingsWithdrawal(amount);
            }
            else if(option == 2){
                customers.get(getCurrentCustomerIndex()).makeSavingsWithdrawal(amount);
            }
            else{
                System.out.println("We are sorry please try again. ");
            }

        }
        else {

            System.out.println("Closing Account.....");
            System.out.println("Successfully Closed");
        }
    }
}
