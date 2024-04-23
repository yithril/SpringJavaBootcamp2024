package org.example;

public class Main {
    public static void main(String[] args) {
        //here's a sentence
        String sentence = "Hello! We love Java programming!";

        String[] words = sentence.split(" ");

        for(String word : words){
            //System.out.println(word);
        }

        String productRow = "1|Laptop|99,999.99|Electronics";

        String[] productInfo = productRow.split("\\|");

        productInfo[2] = productInfo[2].replace(",", "");

        double price = Double.parseDouble(productInfo[2]);

        for(int i = 0; i < productInfo.length; i++){
            System.out.println("Index: " + i + " " + productInfo[i]);
        }
    }
}