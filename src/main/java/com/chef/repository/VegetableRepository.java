package com.chef.repository;

import com.chef.vegetable.Vegetable;
import java.util.List;

// Інтерфейс для роботи з даними про овочі
public interface VegetableRepository {
    // Метод, що повертає список усіх овочів
    List<Vegetable> findAll();
}
