package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give me two numbers to add together:");
        System.out.println(askQuestion("First Number"));
        int firstNumber = scanner.nextInt();
        System.out.println(askQuestion("Second Number"));
        int secondNumber = scanner.nextInt();

        double someVariable = 50;

        //callin the addTwoNumbers
        int sum = addTwoNumbers(firstNumber, secondNumber);

        System.out.println("The sum is: " + sum);
    }

    //DRY Principle
    public static int addTwoNumbers(int firstNumber, int secondNumber){
        int sum = firstNumber + secondNumber;
        return sum;
    }

    public static String askQuestion(String firstPart){
        String fullQuestion = firstPart + " please:";
        return fullQuestion;
    }

    //What if I don't want to return anything???
    public static void greeting(String name){
        System.out.println("Good morning " + name + "!");
    }

    public static int checkNumber(int number){
        //not all code paths return a value
        //you are missing the return for one of your conditions
        if(number > 0){
            return 1;
        }
        else if(number < 0){
            return -1;
        }
        else{
            return 0;
        }
    }
}