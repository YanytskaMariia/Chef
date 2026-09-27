package com.chef.strategy;

import com.chef.vegetable.Vegetable;

import java.util.Comparator;

// Клас для сортування овочів за вагою
public class WeightComparator implements Comparator<Vegetable> {

    @Override
    public int compare(Vegetable first, Vegetable second) {
        return Double.compare(first.getWeight(), second.getWeight());
    }
}