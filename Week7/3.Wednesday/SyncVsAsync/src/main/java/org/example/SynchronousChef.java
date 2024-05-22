package org.example;

import java.util.List;

public class SynchronousChef {
    public static void cookOrderSynchronously(List<Order> orderQueue) {
        long start = System.currentTimeMillis();
        for (Order order : orderQueue) {
            long orderStart = System.currentTimeMillis();
            while (System.currentTimeMillis() - orderStart < order.getTime()) {
                // Blocking
            }
            System.out.println("Synchronously completed order #" + order.getNumber() + ": " + order.getName() + " in " + order.getTime() + "ms");
        }
        System.out.println("Synchronous chef completed all orders in " + (System.currentTimeMillis() - start) + "ms");
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Pizza", 1000, 1),
                new Order("Salad", 500, 2),
                new Order("Steak", 1500, 3),
                new Order("Soup and Salad", 300, 4),
                new Order("Steak and Eggs", 2500, 5),
                new Order("Chicken Sandwich", 1300, 6),
                new Order("Baked Salmon", 3200, 7)
        );

        System.out.println("Starting synchronous chef");
        cookOrderSynchronously(orders);
    }
}
