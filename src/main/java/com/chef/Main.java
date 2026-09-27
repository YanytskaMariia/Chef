package com.chef;

import com.chef.repository.PostgresVegetableRepository;
import com.chef.repository.VegetableRepository;
import com.chef.salad.Salad;
import com.chef.vegetable.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.chef.strategy.WeightComparator;

public class Main {

    public static void main(String[] args) {
        VegetableRepository repository = new PostgresVegetableRepository();
        List<Vegetable> vegetables = repository.findAll();

        Random random = new Random();

        // Створення списків овочів кожного типу
        List<Vegetable> tomatoes = new ArrayList<>();
        List<Vegetable> cucumbers = new ArrayList<>();
        List<Vegetable> rootVegetables = new ArrayList<>();
        List<Vegetable> leafyVegetables = new ArrayList<>();
        List<Vegetable> peppers = new ArrayList<>();
        List<Vegetable> alliumVegetables = new ArrayList<>();

        // Розподіл овочів за типами
        for (Vegetable vegetable : vegetables) {
            if (vegetable instanceof Tomato) {
                tomatoes.add(vegetable);
            } else if (vegetable instanceof Cucumber) {
                cucumbers.add(vegetable);
            } else if (vegetable instanceof RootVegetable) {
                rootVegetables.add(vegetable);
            } else if (vegetable instanceof LeafyVegetable) {
                leafyVegetables.add(vegetable);
            } else if (vegetable instanceof PepperVegetable) {
                peppers.add(vegetable);
            } else if (vegetable instanceof AlliumVegetable) {
                alliumVegetables.add(vegetable);
            }
        }

        // Створення салату
        Salad salad = new Salad();

        // Додавання по одному випадковому овочу кожного типу
        salad.addVegetable(tomatoes.get(random.nextInt(tomatoes.size())));
        salad.addVegetable(cucumbers.get(random.nextInt(cucumbers.size())));
        salad.addVegetable(rootVegetables.get(random.nextInt(rootVegetables.size())));
        salad.addVegetable(leafyVegetables.get(random.nextInt(leafyVegetables.size())));
        salad.addVegetable(peppers.get(random.nextInt(peppers.size())));
        salad.addVegetable(alliumVegetables.get(random.nextInt(alliumVegetables.size())));

        // Виведення овочів, які потрапили до салату
        System.out.println("Овочі в салаті:");

        for (Vegetable vegetable : salad.getVegetables()) {
            System.out.println(vegetable);
        }

        // Виведення загальної калорійності
        System.out.println("Загальна калорійність: "
                + salad.calculateTotalCalories() + " ккал");

        // Сортування овочів у салаті за вагою
        salad.sortVegetables(new WeightComparator());

        System.out.println("\nОвочі в салаті після сортування за вагою:");

        for (Vegetable vegetable : salad.getVegetables()) {
            System.out.println(vegetable);
        }

        // Пошук овочів у заданому діапазоні калорійності
        List<Vegetable> vegetablesInRange = salad.findByCaloriesRange(20, 50);

        System.out.println("\nОвочі з калорійністю від 20 до 50 ккал на 100 г:");

        for (Vegetable vegetable : vegetablesInRange) {
            System.out.println(vegetable);
        }
    }

}