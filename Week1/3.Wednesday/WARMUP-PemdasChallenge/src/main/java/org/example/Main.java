package org.example;

//Sometimes the warm-up is less about coding and more about investigation!
//I have some math equations and I want you to put in what you think these equations will evaluate to.
//Replace the ___ with the actual number YOU think it will be. Then run the program!
//If you need a hint, think PEMDAS.
public class Main {
    public static void main(String[] args) {
        // Equation 1: Basic arithmetic
        int result1 = 10 + 5 * 2;
        // Your prediction:
        System.out.println("You thought result1 would be: ___");
        System.out.println("The reality is: " + result1);

        // Equation 2: Introduction of parentheses
        double result2 = (3 + 5) * 2.5;
        // Your prediction:
        System.out.println("You thought result2 would be: ___");
        System.out.println("The reality is: " + result2);

        // Equation 3: Division and multiplication
        int result3 = 8 / 4 * 2;
        // Your prediction:
        System.out.println("You thought result3 would be: ___");
        System.out.println("The reality is: " + result3);

        // Equation 4: Use of floating point numbers and parentheses
        double result4 = 100 / (2.0 + 3) * 7;
        // Your prediction:
        System.out.println("You thought result4 would be: ___");
        System.out.println("The reality is: " + result4);

        // Equation 5: Introduction of exponentiation
        double result5 = Math.pow(2 * (3 + 1), 2);
        // Your prediction:
        System.out.println("You thought result5 would be: ___");
        System.out.println("The reality is: " + result5);

        // Equation 6: Combination of operations with variables
        int a = 2, b = 3;
        double result6 = a + Math.pow(b, 2) + a * b;
        // Your prediction:
        System.out.println("You thought result6 would be: ___");
        System.out.println("The reality is: " + result6);

        // Equation 7: More complex use of parentheses
        double result7 = (a + b) * (a - b) / (a + 0.5);
        // Your prediction:
        System.out.println("You thought result7 would be: ___");
        System.out.println("The reality is: " + result7);
    }
}