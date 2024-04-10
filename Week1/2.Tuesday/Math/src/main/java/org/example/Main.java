package org.example;

public class Main {
    public static void main(String[] args) {
        int firstNumber = 10;
        int secondNumber = 20;
        //math symbols are + - / * %
        int difference = firstNumber - secondNumber;
        int sum = firstNumber + secondNumber;
        int product = firstNumber * secondNumber;
        int quotient = firstNumber / secondNumber;

        //modulus
        int modulus = secondNumber % firstNumber;

        int thirdNumber = 35;
        //casting
        double floatingResult = (double)thirdNumber / (double)secondNumber;
        //System.out.println(thirdNumber / secondNumber);
        System.out.println(floatingResult);

        //Take 2 and raise it to the third power
        double exponent = Math.pow(2, 3);
        System.out.println("2 to the 3rd power = " + exponent);
    }
}