package com.chef.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Клас для з'єднання з БД
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/chef_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "fake info";  // фейк пароль

    // Метод для з'єднання з БД
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}