package org.example;

public class BankAccount {
    private double balance;
    private String name;

    public BankAccount(double startingBalance, String name){
        this.balance = startingBalance;
        this.name = name;
    }

    public void deposit(double deposit){
        this.balance += deposit;
    }

    public void withdraw(double amount){
        this.balance -= amount;
    }
}
