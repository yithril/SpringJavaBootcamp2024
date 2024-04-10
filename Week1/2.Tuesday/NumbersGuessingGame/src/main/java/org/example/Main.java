package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = 35;

        System.out.println("Guess my hidden number!");
        Scanner scanner = new Scanner(System.in);

        int guess = scanner.nextInt();

        // > < >= <= == !=
        if(guess > number){
            System.out.println("You guessed too high.");
        }
        else if(guess < number){
            System.out.println("You guessed too low.");
        }
        else{
            System.out.println("Winner winner chicken dinner!");
        }

        //how to handle booleans
        boolean someBoolean = true;

        //long way
        //if the boolean is true
        if(someBoolean == true){

        }

        //same thing, less typing
        if(someBoolean){

        }

        //What's the opposite
        if(someBoolean == false){

        }

        //shortway
        if(!someBoolean){

        }
    }
}