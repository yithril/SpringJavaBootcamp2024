package org.example;

public class Main {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];
        String url = "jdbc:mysql://localhost:3306/northwind";

        // To use the safe query manager
        SafeQueryManager safeQueryManager = new SafeQueryManager();
        safeQueryManager.queryDatabase(username, password, url);

        //To use the unsafe query manager, uncomment the following lines
        //UnsafeQueryManager unsafeQueryManager = new UnsafeQueryManager();
        //unsafeQueryManager.queryDatabase(username, password, url);
    }
}