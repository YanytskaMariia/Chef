package com.chef.vegetable;

// Базовий клас для всіх овочів
public abstract class Vegetable {
    private final String name; // назва овоча
    private final double weight; // вага овоча
    private final double caloriesPer100g; // калорійність овоча на 100г

    // Конструктор для створення об'єктів дочірніх класів
    protected Vegetable(String name, double weight, double caloriesPer100g) {

        // Перевірка на коректність отриманих значень
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        if (caloriesPer100g < 0) {
            throw new IllegalArgumentException("Calories cannot be negative");
        }

        this.name = name;
        this.weight = weight;
        this.caloriesPer100g = caloriesPer100g;
    }

    // Методи для отримання значень параметрів конструктора
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    // Метод для розрахунку загальної калорійності овоча
    public double calculateCalories() {
        return weight / 100 * caloriesPer100g;
    }

    // Метод для визначеного текстового представлення
    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", caloriesPer100g=" + caloriesPer100g +
                '}';
    }
}
