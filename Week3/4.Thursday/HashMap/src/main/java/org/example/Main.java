package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //in a hash map all keys are unique
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Smith, John", "1-555-720-3384");
        phoneBook.put("Woodward, Bob", "1-555-867-5309");

        //if you use put for the same key, it will update
        phoneBook.put("Woodward, Bob", "1-784-000-9874");

        for(String values : phoneBook.values()){
            System.out.println(values);
        }

        for(String key : phoneBook.keySet()){
            System.out.println(key);
        }

        System.out.println("Bob Woodward's phone number is: " + phoneBook.get("Woodward, Bob"));

        Map<Product, Integer> inventory = new HashMap<>();

        Product shoe = new Product("Air Jordan's", 500);

        inventory.put(shoe, 100);

        //someone bought 50 air jordans
        inventory.put(shoe, 50);

        System.out.println(inventory.get("Bananas"));

        //check if hashmap has a certain key
        phoneBook.containsKey("Bob");
    }
}