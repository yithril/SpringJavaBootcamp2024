package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        int[] numbers2 = new int[10];
        int[] numbers3 = new int[2];

        //array of strings
        String[] stringArray = new String[4];
        Person[] personArray = new Person[5];

        personArray[0] = new Person();
        personArray[0] = null;

        System.out.println("Numbers length is: " + numbers.length);
        System.out.println("Numbers2 length is: " + numbers2.length);
        System.out.println("Numbers3 length is: " + numbers3.length);

        numbers[0] = 19;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        //numbers[5] = 60;

        //You can change the values later as you want
        //numbers[1] = 100;

        //clear a value
        //numbers[4] = 0;

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

        //enhanced for loop
        for(int number : numbers){
            System.out.println(number);
        }
    }
}