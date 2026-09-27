package com.chef.salad;

import com.chef.vegetable.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

// Клас для представлення салату
public class Salad {

    private final List<Vegetable> vegetables;

    public Salad() {
        vegetables = new ArrayList<>();
    }
    // Метод для додавання овоча до салату
    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }
    // Метод для обчислення загальної калорійності салату
    public double calculateTotalCalories() {
        double totalCalories = 0;

        for (Vegetable vegetable : vegetables) {
            totalCalories += vegetable.calculateCalories();
        }

        return totalCalories;
    }
    // Метод для сортування овочів за заданим параметром
    public void sortVegetables(Comparator<Vegetable> comparator) {
        vegetables.sort(comparator);
    }
    // Метод для пошуку овочів в заданому діапазоні каорійності
    public List<Vegetable> findByCaloriesRange(double minCalories, double maxCalories) {
        List<Vegetable> result = new ArrayList<>();

        for (Vegetable vegetable : vegetables) {
            double calories = vegetable.getCaloriesPer100g();

            if (calories >= minCalories && calories <= maxCalories) {
                result.add(vegetable);
            }
        }

        return result;
    }
}