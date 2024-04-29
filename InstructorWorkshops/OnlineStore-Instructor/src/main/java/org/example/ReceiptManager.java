package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReceiptManager {
    public void writeReceipt(ArrayList<Product> products) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = "src/main/resources/receipts/receipt_" + sdf.format(new Date()) + ".txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            double total = 0;
            fw.write("********** Receipt **********\n");
            for (Product product : products) {
                String line = String.format("SKU: %s - %s - $%.2f\n", product.getSku(), product.getProductName(), product.getPrice());
                fw.write(line);
                total += product.getPrice();
            }
            fw.write("\nTotal: $" + String.format("%.2f", total) + "\n");
            fw.write("****************************\n");
        } catch (IOException ex) {
            System.err.println("Error writing the receipt: " + ex.getMessage());
        }
    }
}