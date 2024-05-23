package org.example;

public class BankAccount {
    //instance field
    private double balance;
    private String name;
    //if it doesn't change from instance to instance static makes sense
    private static double interestRate;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getInterestRate(){
        return interestRate;
    }
}
