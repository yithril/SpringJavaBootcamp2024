package org.example;
import java.sql.*;
import java.util.Scanner;

public class SafeQueryManager {
    public void queryDatabase(String username, String password, String url) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter EmployeeID:");
            int employeeId = scanner.nextInt();

            String query = "SELECT FirstName, LastName, Title FROM Employees WHERE EmployeeID = ?";
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, employeeId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Employee: " + rs.getString("FirstName") + " " + rs.getString("LastName") + " " + rs.getString("Title"));
                    } else {
                        System.out.println("No employee found with that ID.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

