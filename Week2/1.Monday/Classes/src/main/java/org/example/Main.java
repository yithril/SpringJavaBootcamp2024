package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //instantiate the Scanner
        //Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        Dog fido = new Dog("black", "German Shepherd", 2, 3.5);
        Dog bandit = new Dog("orange", "Golden Retriever", 5, 4.5);

        fido.bark();
        bandit.bark();

        System.out.println(fido.getFurColor());

        fido.setFurColor("gold");

        System.out.println("Fido's fur color is now: " + fido.getFurColor());

//        BankAccount newAccount = new BankAccount(100, "Jonathan");
//
//        newAccount.deposit(150);
//        newAccount.withdraw(50);
    }
}