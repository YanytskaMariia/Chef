package com.chef.repository;

import com.chef.vegetable.*;
import java.util.List;
import com.chef.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// Клас для отримання даних про овочі з PostgreSQL
public class PostgresVegetableRepository implements VegetableRepository {

    @Override
    public List<Vegetable> findAll() {

        // Список для зберігання овочів, отриманих з БД
        List<Vegetable> vegetables = new ArrayList<>();

        String sql = """
         SELECT name, category, weight, calories_per_100g
            FROM vegetables
        """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                double weight = resultSet.getDouble("weight");
                double calories = resultSet.getDouble("calories_per_100g");

                Vegetable vegetable;

                // Створення відповідного типу овоча за його категорією
                switch (category) {
                    case "TOMATO":
                        vegetable = new Tomato(name, weight, calories);
                        break;

                    case "CUCUMBER":
                        vegetable = new Cucumber(name, weight, calories);
                        break;

                    case "ROOT":
                        vegetable = new RootVegetable(name, weight, calories);
                        break;

                    case "LEAFY":
                        vegetable = new LeafyVegetable(name, weight, calories);
                        break;

                    case "PEPPER":
                        vegetable = new PepperVegetable(name, weight, calories);
                        break;

                    case "ALLIUM":
                        vegetable = new AlliumVegetable(name, weight, calories);
                        break;

                    default:
                        throw new IllegalArgumentException(
                                "Unknown vegetable category: " + category
                        );
                }

                vegetables.add(vegetable);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vegetables;
    }
}
