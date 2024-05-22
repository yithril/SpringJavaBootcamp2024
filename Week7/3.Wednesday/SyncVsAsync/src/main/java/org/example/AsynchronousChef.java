package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynchronousChef {
    public static void cookOrderAsynchronously(List<Order> orderQueue) {
        long start = System.currentTimeMillis();
        List<CompletableFuture<Void>> futures = orderQueue.stream()
                .map(order -> CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(order.getTime());
                        System.out.println("Asynchronously completed order #" + order.getNumber() + ": " + order.getName() + " in " + order.getTime() + "ms");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.thenRun(() -> {
            System.out.println("Asynchronous chef completed all orders in " + (System.currentTimeMillis() - start) + "ms");
        });

        try {
            allOf.get(); // Block to ensure all tasks are completed
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
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

        System.out.println("Starting asynchronous chef");
        cookOrderAsynchronously(orders);
    }
}