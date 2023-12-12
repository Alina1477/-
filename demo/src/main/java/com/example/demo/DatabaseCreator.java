package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseCreator {

    public static void main(String[] args) {
        createDatabase();
        createTables();
    }

    private static void createDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db")) {
            if (connection != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    private static void createTables() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:recipes.db");
             Statement statement = connection.createStatement()) {

            // Создание таблиц
            String createRecipesTableSQL = "CREATE TABLE IF NOT EXISTS Recipes (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "category TEXT NOT NULL," +
                    "photo BLOB," +
                    "cooking_time INTEGER NOT NULL," +
                    "calories REAL NOT NULL," +
                    "proteins REAL NOT NULL," +
                    "fats REAL NOT NULL," +
                    "carbohydrates REAL NOT NULL," +
                    "difficulty TEXT," +
                    "confirmed INTEGER DEFAULT 0)";

            String createIngredientsTableSQL = "CREATE TABLE IF NOT EXISTS Ingredients (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT NOT NULL," +
                    "calories REAL NOT NULL," +
                    "proteins REAL NOT NULL," +
                    "fats REAL NOT NULL," +
                    "carbohydrates REAL NOT NULL)";

            // Добавьте здесь SQL-запросы для создания остальных таблиц

            statement.executeUpdate(createRecipesTableSQL);
            statement.executeUpdate(createIngredientsTableSQL);

            System.out.println("Tables created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }
}
