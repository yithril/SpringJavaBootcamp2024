package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();

        System.out.println(BankAccount.getInterestRate());

        FileManager.readDealership();
        FileManager.readDealership();
    }
}