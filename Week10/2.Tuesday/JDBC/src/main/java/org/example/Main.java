package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CategoryRepository cr = new CategoryRepository("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);

//        var categories = cr.getAllCategories(args[0], args[1]);
//
//        for(Category category : categories){
//            System.out.println(category.getCategoryName());
//        }

        CustomerOrderRepository cor = new CustomerOrderRepository("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);

        System.out.println("What customer do you want to see the order history for?");
        Scanner scanner = new Scanner(System.in);
        var customerId = scanner.nextLine();

        var histories = cor.getCustomerOrderHistory(customerId);

        for(CustomerOrderHistory history : histories){
            System.out.println(history.getProductName() + " " + history.getTotal());
        }
    }
}