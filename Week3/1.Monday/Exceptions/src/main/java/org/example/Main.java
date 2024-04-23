package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please put in a number.");
        try{
            //parsing
            int number = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the next number");

            int secondNumber = Integer.parseInt(scanner.nextLine());

            System.out.println("What is your name?");
            String name = scanner.nextLine();

            System.out.println("Result: " + (number/secondNumber));
        }
        catch (InputMismatchException ex){
            System.out.println("Please input a number.");
        }
        catch (ArithmeticException ex){
            System.out.println("Cannot perform that operation!");
        }
        catch(NumberFormatException ex){
            System.out.println("Please type in a number.");
        }
        catch(Exception ex){
            System.out.println("Sorry about that! We're working on it.");
        }
    }
}