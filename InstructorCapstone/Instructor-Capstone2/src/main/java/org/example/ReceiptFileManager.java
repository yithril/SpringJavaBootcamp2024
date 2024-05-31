package org.example;

import org.example.enums.IngredientType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReceiptFileManager {
    private static final String RECEIPT_FOLDER = "src/main/resources/receipts/";
    private static final DateTimeFormatter FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private ReceiptFileManager() {
        // Private constructor to prevent instantiation
    }

    public static void writeReceipt(Order order) {
        String receiptName = generateReceiptName();
        File file = new File(RECEIPT_FOLDER + receiptName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Receipt - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n");
            writeOrderDetails(writer, order);
            System.out.println("Receipt written to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    private static String generateReceiptName() {
        return "Receipt_" + LocalDateTime.now().format(FILE_NAME_FORMATTER) + ".txt";
    }

    private static void writeOrderDetails(BufferedWriter writer, Order order) throws IOException {
        // Writing sandwiches
        if (!order.getSandwiches().isEmpty()) {
            writer.write("Sandwiches:\n");
            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write(" - " + sandwich.getSandwichSize() + " " + getBreadName(sandwich) + " Sandwich\n");
                writeSandwichIngredients(writer, sandwich);
                writer.write("   Price: $" + sandwich.getTotalPrice() + "\n\n");
            }
        }

        // Writing side items
        if (!order.getSideItems().isEmpty()) {
            writer.write("Side Items:\n");
            Map<String, Integer> sideItemCounts = new HashMap<>();
            order.getSideItems().forEach(sideItem ->
                    sideItemCounts.merge(sideItem.getName(), 1, Integer::sum));

            for (Map.Entry<String, Integer> entry : sideItemCounts.entrySet()) {
                SideItem sideItem = order.getSideItems().stream()
                        .filter(si -> si.getName().equals(entry.getKey()))
                        .findFirst()
                        .orElse(null);
                if (sideItem != null) {
                    writer.write(" - " + entry.getKey() + " (x" + entry.getValue() + ") - Each: $"
                            + sideItem.getPrice() + ", Total: $"
                            + sideItem.getPrice().multiply(BigDecimal.valueOf(entry.getValue())) + "\n");
                }
            }
        }
    }

    private static String getBreadName(Sandwich sandwich) {
        return sandwich.getIngredientList().stream()
                .filter(ingredient -> ingredient.getIngredientType() == IngredientType.BREAD)
                .findFirst()
                .map(Ingredient::getName)
                .orElse("Unknown Bread");
    }

    private static void writeSandwichIngredients(BufferedWriter writer, Sandwich sandwich) throws IOException {
        writer.write("   Toppings:\n");
        Map<Boolean, List<Ingredient>> toppings = sandwich.getIngredientList().stream()
                .filter(ingredient -> ingredient.getIngredientType() != IngredientType.BREAD)
                .collect(Collectors.partitioningBy(ingredient -> ingredient.getPrice(sandwich.getSandwichSize()).compareTo(BigDecimal.ZERO) > 0));

        if (!toppings.get(true).isEmpty()) {
            writer.write("    - With Cost:\n");
            for (Ingredient ingredient : toppings.get(true)) {
                writer.write("      " + ingredient.getName() + ": $" + ingredient.getPrice(sandwich.getSandwichSize()) + "\n");
            }
        }

        if (!toppings.get(false).isEmpty()) {
            writer.write("    - No Cost:\n");
            for (Ingredient ingredient : toppings.get(false)) {
                writer.write("      " + ingredient.getName() + "\n");
            }
        }
    }
}
