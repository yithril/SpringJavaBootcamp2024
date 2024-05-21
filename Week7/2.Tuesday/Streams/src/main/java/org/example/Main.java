package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product("Phone", 599.99),
                new Product("Tablet", 399.99),
                new Product("Monitor", 299.99),
                new Product("Keyboard", 49.99),
                new Product("Mouse", 25.99),
                new Product("Printer", 149.99),
                new Product("Camera", 699.99),
                new Product("Headphones", 199.99),
                new Product("Smartwatch", 249.99),
                new Product("Speaker", 89.99),
                new Product("Router", 129.99),
                new Product("External Hard Drive", 79.99),
                new Product("Microphone", 99.99)
        );

        //What products do we have that are over $500?
        var overFiveHundred = products.stream().filter(product -> product.getPrice() > 500).toList();

        overFiveHundred.forEach(x -> System.out.println(x.toString()));

        var betweenTwoAndFourHundred = products.stream()
                .filter(product -> product.getPrice() > 200 && product.getPrice() < 400)
                .toList();

        //What are the names of the products we sell?
        //method reference
        products.stream().map(Product::getName).sorted().toList().forEach(name -> System.out.println(name));

        //What is the sum of all our prices?
        var totalOfPrices = products.stream().map(Product::getPrice).reduce(0.0, Double::sum);

        //What if we want the average price?
        var averagePrice = totalOfPrices / products.stream().count();

        //there is a shorter way to do this
        var shorterWay = products.stream().mapToDouble(Product::getPrice).average().orElse(0);

        //what is our most expensive product?
        var mostExpensive = products.stream().mapToDouble(Product::getPrice).max().orElse(0);
    }
}