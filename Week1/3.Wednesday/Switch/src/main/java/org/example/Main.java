package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your sign?");
        String userInput = scanner.nextLine();
        System.out.println("All lower case " + userInput.toLowerCase());

        switch(userInput.toLowerCase()){
            case "capricorn":
                System.out.println("Capricorns are the money makers!");
                break;
            case "aquarius":
                System.out.println("You are the water bearer!");
                break;
            case "pisces":
                System.out.println("Your sign is the fish");
                break;
            case "leo":
            case "cancer":
                System.out.println("Leo and Cancer are so similar!");
                break;
            default:
                System.out.println("Sorry that is not a sign");
                break;
        }
    }
}