package org.example;

public class Product {
    private String name;
    private double price;
    private String category;
    private int rating;

    public Product(String name, double price, String category, int rating) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                '}';
    }
}
