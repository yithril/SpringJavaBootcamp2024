package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dbUserName = args[0];
        String dbPassword = args[1];
        String connectionString = "jdbc:mysql://localhost:3306/northwind";

        ProductDao productDao = new ProductDao(connectionString, dbUserName, dbPassword);

        //grab products from database
        List<Product> productList = productDao.getAll();

        System.out.println("Here is our list of products at Northwind:");
        productList.stream().forEach(x -> System.out.println(x.toString()));
    }
}