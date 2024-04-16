package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //while loops
        int dormamuHasHadEnough = 0;

        while(dormamuHasHadEnough < 10){
            System.out.println("Dormamu I've come to bargain");
            System.out.println("Dormamu destroys Dr. Strange brutally.");
            dormamuHasHadEnough++; //fancy way of adding one to the variable
        }

        //System.out.println("The earth is saved!");

        //little trick you can do
//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            System.out.println("This will run forever.");
//            System.out.println("Do you want to stop?");
//            String input = scanner.nextLine();
//            if(input.equalsIgnoreCase("yes")){
//                System.out.println("Exiting while loop");
//                break;
//            }
//        }

        //for loops
        //when you have an idea of how many times you wanna do something
        for(int i = 10; i > 0; i--){
            System.out.println("For loop, i is: " + i);
        }

        for(int i = 0; i < 10; i++){

        }
    }
}