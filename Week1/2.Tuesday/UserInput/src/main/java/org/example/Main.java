package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What is your name?");

        //class that is built-in to take user input
        Scanner scanner = new Scanner(System.in);

        //You expect the user to give you a string, therefore nextLine
        String name = scanner.nextLine();

        System.out.println("Where are you from?");

        String location = scanner.nextLine();

        //System.out.println("Hello there " + name + " and you are from " + location);
        //s is for string f is for float d is for integer, remember the \n for a new line
        System.out.printf("Hello there, %s, and you are from %s \n", name, location);

        System.out.println("How old are you?");

        int age = scanner.nextInt();

        //System.out.println("You are " + age + " years old");
        System.out.printf("You are %d years old", age);
    }
}