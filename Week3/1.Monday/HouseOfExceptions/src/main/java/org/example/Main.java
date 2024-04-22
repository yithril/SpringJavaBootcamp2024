package org.example;

public class Main {
    public static void main(String[] args) {
        // Example 1: ArithmeticException
        try {
            int a = 5;
            int b = 0;
            System.out.println("Attempting division by zero: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        }

        // Example 2: NumberFormatException
        try {
            String number = "abc123";
            int result = Integer.parseInt(number);
            System.out.println("Parsed integer: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Caught a NumberFormatException: " + e.getMessage());
        }

        // Example 3: ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing out of bounds index: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // Example 4: NullPointerException
        try {
            String data = null;
            System.out.println("Attempting to access method of null object: " + data.length());
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }

        // Example 5: Custom Exception Handling
        try {
            checkUserAge(17);
        } catch (Exception e) {
            System.out.println("Caught a custom Exception: " + e.getMessage());
        }
    }

    // Method that throws a custom exception
    static void checkUserAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("User must be 18 or older");
        } else {
            System.out.println("User is of valid age.");
        }
    }
}