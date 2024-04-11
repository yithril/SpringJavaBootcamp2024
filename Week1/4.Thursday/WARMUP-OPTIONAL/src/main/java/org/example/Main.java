package org.example;

public class Main {
    public static void main(String[] args) {
        //In this warm up you are going to refactor code!
        //Please look up the ternary operator and rewrite the following if-else statements using it:
        //Ternary operator example:
        //int a = 10, b = 5;
        //int max = (a > b) ? a : b;

        //#1
        int a = 10, b = 20;
        int max;

        if (a > b) {
            max = a;
        } else {
            max = b;
        }

        //#2
        String message = "hello";
        String shout;

        if (message.equals("hello")) {
            shout = "HELLO!";
        } else {
            shout = "hi...";
        }

        //#3
        String username = "l33tGamer";
        String greeting;

        if (username != null) {
            greeting = "Welcome, " + username;
        } else {
            greeting = "Welcome, guest";
        }

        //DISCUSSION
        //You do not have to rewrite this code. I'd like for you to think which code is more readable in your opinion.
        //Both code blocks do the same thing. Which is more understandable to you?

        //Code A
        int hoursWorked = 50;
        int basePay = 20;
        int overtimeHours = hoursWorked > 40 ? hoursWorked - 40 : 0;
        double totalPay = basePay * 40 + (overtimeHours > 0 ? overtimeHours * (basePay * 1.5) : 0);


        //Code B
        if (hoursWorked > 40) {
            overtimeHours = hoursWorked - 40;
            totalPay = basePay * 40 + overtimeHours * (basePay * 1.5);
        } else {
            totalPay = basePay * hoursWorked;
        }
    }
}