package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter score for test 1:");
        double score1 = scanner.nextDouble();
        TestScore test1 = new TestScore(score1);

        System.out.println("Enter score for test 2:");
        double score2 = scanner.nextDouble();
        TestScore test2 = new TestScore(score2);

        System.out.println("Enter score for test 3:");
        double score3 = scanner.nextDouble();
        TestScore test3 = new TestScore(score3);

        double average = (test1.getScore() + test2.getScore() + test3.getScore()) / 2;

        System.out.println("The average score is: " + average);

        scanner.close();
    }
}