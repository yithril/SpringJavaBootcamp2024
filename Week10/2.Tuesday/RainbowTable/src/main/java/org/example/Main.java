package org.example;

import java.sql.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String dbUsername = "root";
        String password = "Leeames123!";

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(url, dbUsername, password)) {
            // Fetch user information including hashed passwords
            String sql = "SELECT username, password_hash FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a hashmap to simulate the rainbow table
            HashMap<String, String> rainbowTable = new HashMap<>();

            // Populate the rainbow table with precomputed hashes and usernames
            while (resultSet.next()) {
                String usernameFromDB = resultSet.getString("username");
                String passwordHash = resultSet.getString("password_hash");
                rainbowTable.put(passwordHash, usernameFromDB);
            }

            // Simulate the attack by checking hashed passwords against the rainbow table
            for (String hashedPassword : rainbowTable.keySet()) {
                // Check if the hashed password exists in the rainbow table
                if (rainbowTable.containsKey(hashedPassword)) {
                    String username = rainbowTable.get(hashedPassword);
                    System.out.println("Cracked Password for User " + username + ": " + hashedPassword);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getUsernameByPasswordHash(String passwordHash, HashMap<String, String> rainbowTable) {
        for (String hashedPassword : rainbowTable.keySet()) {
            if (rainbowTable.get(hashedPassword).equals(passwordHash)) {
                return rainbowTable.get(hashedPassword);
            }
        }
        return null;
    }
}