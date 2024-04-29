package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {
    public static List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

        String filePath = "src/main/resources/products.csv";
        //try-with it cleans up automatically
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                //deserialize
                String[] data = line.split("\\|");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2].replace(",", ""));
                String category = data[3];

                Product product = new Product(id, name, price, category);
                products.add(product);
            }
        }
        catch(IOException ex){
            System.out.println("Sorry couldn't read the file.");
        }

        for(Product product : products){
            System.out.printf("Id: %d Name: %s Price: $%.2f Category: %s \n",
                    product.getId(), product.getName(), product.getPrice(), product.getCategory());
        }

        return products;
    }

    public static void writeProductToFile(Product product){
        String filePath = "src/main/resources/products.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(product.getId() + "|" + product.getName() + "|" + product.getPrice()
                            + "|" + product.getCategory());
            writer.newLine();
            //optional message
            System.out.println("Printed successfully!");
        }
        catch (IOException ex){
            System.out.println("File could not be written to.");
        }
    }
}
