package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private static final String PRODUCT_FILE = "src/main/resources/products.csv";

    // Load products from file
    public List<Product> loadProductsFromFile() {
        List<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(PRODUCT_FILE))) {
            scanner.nextLine(); // Skip header line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                products.add(parseProduct(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Product file not found.");
        }
        return products;
    }

    // Write a single product to file
    public void writeProductToFile(Product product) {
        try (FileWriter fw = new FileWriter(PRODUCT_FILE, true)) {
            fw.write(productToFileFormat(product) + "\n");
        } catch (IOException e) {
            System.err.println("Error: Unable to write to the product file.");
        }
    }

    // Remove a product by SKU
    public void removeProductFromFile(String sku) {
        List<Product> products = loadProductsFromFile();
        List<Product> updatedList = new ArrayList<>();

        boolean found = false;
        for (Product product : products) {
            if (!product.getSku().equals(sku)) {
                updatedList.add(product);
            } else {
                found = true;
            }
        }

        if (found) {
            rewriteProductFile(updatedList);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Helper method to rewrite the entire product file
    private void rewriteProductFile(List<Product> products) {
        try (FileWriter fw = new FileWriter(PRODUCT_FILE)) {
            for (Product product : products) {
                fw.write(productToFileFormat(product) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error: Unable to rewrite the product file.");
        }
    }

    // Search for products by name
    public List<Product> searchForProductsByName(String name) {
        List<Product> products = loadProductsFromFile();
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> products = loadProductsFromFile();
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    // Get products by department
    public List<Product> getProductsByDepartment(String department) {
        List<Product> products = loadProductsFromFile();
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDepartment().equalsIgnoreCase(department)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    // Helper method to parse a product from a CSV line
    private Product parseProduct(String line) {
        String[] data = line.split("\\|");
        return new Product(data[0], data[1], Double.parseDouble(data[2]), data[3]);
    }

    // Helper method to convert a product to a CSV line format
    private String productToFileFormat(Product product) {
        return String.format("%s|%s|%.2f|%s", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
    }
}
