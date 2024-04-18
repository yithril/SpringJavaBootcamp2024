package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testScores = { 100, 56, 72, 85, 100, 45, 35, 90, 54, 67 };

        //average score of the class
        int sum = 0;

        //loop through the array
        for(int score : testScores){
            //add each element of the array to the sum
            sum += score;
        }

        //take the final sum and divide it by testScores.length
        double average = (double)sum / (double)testScores.length;

        //sort an array sort means put in order
        Arrays.sort(testScores);

        for(int score : testScores){
            System.out.println(score);
        }
    }
}