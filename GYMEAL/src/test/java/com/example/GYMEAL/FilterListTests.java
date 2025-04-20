/* Tests for FilterList Class
 * Purpose: tests for methods found in the FilterList class.
 * */

package com.example.GYMEAL;

import CSV.FilterList;
import Filters.Food;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FilterListTests {

    //creates an instance of FilterList class
    FilterList filterList = new FilterList();

    //tests CaloriesFilter using 3 different ranges seen below.
    @Test
    public void testFilterByCalories()
    {
        ArrayList<Food> foodsFilteredList;

        //Range: 50 - 100 cals
        //Expected list size: 5
        foodsFilteredList = filterList.filterByCalories(50, 100);
        System.out.println("Foods with calories that range from 50 to 100: ");
        for(int i = 0; i < foodsFilteredList.size(); i++)
        {
            System.out.println(foodsFilteredList.get(i).toString());
        }
        System.out.println("List size: " + foodsFilteredList.size());
        System.out.println();

        //Range: 100 - 400 cals
        //Expected list size: 14
        foodsFilteredList = filterList.filterByCalories(100, 400);
        System.out.println("Foods with calories that range from 100 to 400: ");
        for(int i = 0; i < foodsFilteredList.size(); i++)
        {
            System.out.println(foodsFilteredList.get(i).toString());
        }
        System.out.println("List size: " + foodsFilteredList.size());
        System.out.println();

        //Range: 500 - 600 cals
        //Expected list size: 0
        foodsFilteredList = filterList.filterByCalories(500, 600);
        System.out.println("Foods with calories that range from 500 to 600: ");
        for(int i = 0; i < foodsFilteredList.size(); i++)
        {
            System.out.println(foodsFilteredList.get(i).toString());
        }
        System.out.println("List size: " + foodsFilteredList.size());
    }
}
