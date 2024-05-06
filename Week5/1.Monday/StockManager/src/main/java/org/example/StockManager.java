package org.example;

import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private Map<String, Product> stock;

    public StockManager() {
        this.stock = new HashMap<>();
    }

    public boolean addStock(String productName, int quantity) {
        if (quantity <= 0) { // Bug: Allows non-positive quantities to be added
            return false;
        }
        Product product = stock.get(productName);
        if (product == null) {
            stock.put(productName, new Product(productName, quantity));
        } else {
            product.setQuantity(product.getQuantity() + quantity);
        }
        return true;
    }

    public boolean removeStock(String productName, int quantity) {
        Product product = stock.get(productName);
        if (product == null || product.getQuantity() < quantity) {
            return false;
        }
        product.setQuantity(product.getQuantity() - quantity);
        return true;
    }

    public int getStock(String productName) {
        Product product = stock.get(productName);
        return product != null ? product.getQuantity() : -1;
    }
}
