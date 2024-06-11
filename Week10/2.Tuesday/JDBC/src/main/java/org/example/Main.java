package org.example;

public class Main {
    public static void main(String[] args) {
        CategoryRepository cr = new CategoryRepository("jdbc:mysql://localhost:3306/northwind", args[0], args[1]);

        var categories = cr.getAllCategories(args[0], args[1]);

        for(Category category : categories){
            System.out.println(category.getCategoryName());
        }
    }
}