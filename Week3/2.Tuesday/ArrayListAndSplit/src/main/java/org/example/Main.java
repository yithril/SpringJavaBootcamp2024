package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //arrays are sometimes too rigid
        //The more flexible version of an array is called an ArrayList
        //Use classes not primitives (like Integer, Boolean, etc.)
        List<String> groceryList = new ArrayList<>();

        groceryList.add("Peanut Butter");
        groceryList.add("Ice cream");
        groceryList.add("Sugar");

        groceryList.remove("Peanut Butter");

        //remember, arraylists have index starts at 0
        System.out.println(groceryList.get(1));

        //How many things in it?
        System.out.println(groceryList.size());

        //loops
        for(String groceryItem : groceryList){
            System.out.println(groceryItem);
        }

        List<String> fruits = new ArrayList<>(Arrays.asList("Banana", "Strawberry", "Mango", "Apricot", "Kumquat", "DragonFruit"));
        List<String> fruits2 = new ArrayList<>(List.of("Banana", "Strawberry", "Mango", "Apricot", "Kumquat", "DragonFruit"));
    }
}