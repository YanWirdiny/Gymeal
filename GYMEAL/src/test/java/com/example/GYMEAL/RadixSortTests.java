package com.example.GYMEAL;

import Filters.Food;
import Filters.RadixSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RadixSortTests {
    public RadixSort radixSort = new RadixSort();
    public ArrayList<Food> foods = new ArrayList<>();
    @Test
    public void addFood()
    {
        foods.add(new Food("Chicken", 200, 30.0, 1.0, 1.0, "meats"));
        foods.add(new Food("Lettuce", 100, 1.0, 5.0, 0.0, "vegetables"));
        foods.add(new Food("Peach", 80, 0.0, 3.0, 4.0, "fruits"));
        foods.add(new Food("Rice", 75, 3.0, 20, 1.0, "grains"));
        foods.add(new Food("Gatorade", 150, 0.0, 2.0, 3.0, "drinks"));
    }

    @Test
    public void getMaxTest()
    {
        addFood();
        System.out.println("Food with max caloric value: " + radixSort.getMax(foods));
    }

    @Test
    public void radixSortTest()
    {
        addFood();
        radixSort.radixSort(foods);
        radixSort.print(foods);
    }
}
