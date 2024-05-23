package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 999.99, "Electronics", 5));
        products.add(new Product("Smartphone", 599.99, "Electronics", 4));
        products.add(new Product("Tablet", 399.99, "Electronics", 3));
        products.add(new Product("Headphones", 199.99, "Electronics", 4));
        products.add(new Product("Smartwatch", 249.99, "Electronics", 3));
        products.add(new Product("Camera", 499.99, "Electronics", 5));
        products.add(new Product("Printer", 149.99, "Office Supplies", 4));
        products.add(new Product("Desk", 89.99, "Office Supplies", 4));
        products.add(new Product("Chair", 129.99, "Office Supplies", 3));
        products.add(new Product("Notebook", 2.99, "Office Supplies", 5));
        products.add(new Product("Pen", 0.99, "Office Supplies", 4));
        products.add(new Product("Pencil", 0.49, "Office Supplies", 3));
        products.add(new Product("Backpack", 49.99, "Accessories", 4));
        products.add(new Product("Watch", 199.99, "Accessories", 5));
        products.add(new Product("Sunglasses", 99.99, "Accessories", 4));
        products.add(new Product("Hat", 24.99, "Accessories", 3));
        products.add(new Product("Scarf", 19.99, "Accessories", 4));
        products.add(new Product("Shoes", 89.99, "Footwear", 5));
        products.add(new Product("Sandals", 29.99, "Footwear", 3));
        products.add(new Product("Boots", 129.99, "Footwear", 4));
        products.add(new Product("Sneakers", 59.99, "Footwear", 4));
        products.add(new Product("Socks", 9.99, "Footwear", 5));
        products.add(new Product("Blender", 79.99, "Home Appliances", 4));
        products.add(new Product("Toaster", 29.99, "Home Appliances", 3));
        products.add(new Product("Microwave", 89.99, "Home Appliances", 4));
        products.add(new Product("Refrigerator", 599.99, "Home Appliances", 5));
        products.add(new Product("Oven", 499.99, "Home Appliances", 4));
        products.add(new Product("Mug", 14.99, "Kitchenware", 5));
        products.add(new Product("Plate", 9.99, "Kitchenware", 4));
        products.add(new Product("Cutlery Set", 49.99, "Kitchenware", 3));
    }
}