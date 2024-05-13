package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal firstNumber = new BigDecimal(".1");
        BigDecimal secondNumber = new BigDecimal(".2");

        var sum = firstNumber.add(secondNumber);
        var difference = firstNumber.subtract(secondNumber);
        var product = firstNumber.multiply(secondNumber);
        var quotient = firstNumber.divide(secondNumber);

        //System.out.println(sum);

        BigDecimal money1 = BigDecimal.valueOf(.3);

        //comparisons
        //We cannot use > < >= <=
        //1 is greater than, -1 is less than, 0 is equal
        int compareResult = secondNumber.compareTo(firstNumber);

        //System.out.println(compareResult);

        //rounding
        BigDecimal weirdNumber = new BigDecimal("10.7852839203893");

        BigDecimal roundedValue = weirdNumber.setScale(2, RoundingMode.HALF_UP);

        System.out.println(roundedValue);
    }
}