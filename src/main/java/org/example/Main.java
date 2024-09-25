package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.connect()) {
            String insertSql = "INSERT INTO phones (model, price) VALUES ('Nokia 3310', 59.99)";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertSql);
            System.out.println("Record inserted successfully!");

            String selectSql = "SELECT * FROM phones";
            ResultSet resultSet = stmt.executeQuery(selectSql);
            System.out.println("Phones in the database:");
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                System.out.println("Model: " + model + ", Price: " + price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}