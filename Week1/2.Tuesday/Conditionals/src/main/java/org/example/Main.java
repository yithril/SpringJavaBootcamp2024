package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String favoriteColor = "Blue";

        System.out.println("What do you think is my favorite color?");

        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();

        //conditional
        //equals is an EXACT match
        if(result.equalsIgnoreCase("Blue")){
            System.out.println("Yes, Blue is my favorite color!");
        }
        else{
            System.out.println("Sorry better luck next time.");
        }
    }
}