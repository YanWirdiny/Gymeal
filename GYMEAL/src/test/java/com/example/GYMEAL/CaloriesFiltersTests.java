/* Tests for CaloriesFilter class
 * Purpose: tests all methods found in the CaloriesFilter class.
 * It should be noted that there is a private method within this class that can only be accessed via the filterByCalories()
 * method.
 * */

package com.example.GYMEAL;

import CSV.ReadCSV;
import Filters.CaloriesFilter;
import Filters.Food;
import Filters.RadixSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CaloriesFiltersTests {

    CaloriesFilter caloriesFilter = new CaloriesFilter();

    //used to generate unfiltered list form CSV file
    ReadCSV reader = new ReadCSV();
    ArrayList<Food> unfilteredFoods = reader.readDataCSV();


    /* tests the following methods:
     * apply()
     * filterByCalories()
     *
     * The setRange() method is also tested but since it is only accessed via the filterByCalories() method (because
     * of its private status), it's not explicitly seen that we test this method.
     * */

    //given a range, returns a list of foods that fall within the caloric range
    @Test
    public void filterByCaloriesTest()
    {
        ArrayList<Food> foodsFilteredList;

        //Range: 50 - 100 cals
        //Expected list size: 5
        foodsFilteredList = caloriesFilter.filterByCalories(unfilteredFoods,50, 100);
        System.out.println("Foods with calories that range from 50 to 100: ");
        for(int i = 0; i < foodsFilteredList.size(); i++)
        {
            System.out.println(foodsFilteredList.get(i).toString());
        }
        System.out.println("List size: " + foodsFilteredList.size());
        System.out.println();

        //Range: 100 - 400 cals
        //Expected list size: 14
        foodsFilteredList = caloriesFilter.filterByCalories(unfilteredFoods,100, 400);
        System.out.println("Foods with calories that range from 100 to 400: ");
        for(int i = 0; i < foodsFilteredList.size(); i++)
        {
            System.out.println(foodsFilteredList.get(i).toString());
        }
        System.out.println("List size: " + foodsFilteredList.size());
        System.out.println();


        //Range: 500 - 600 cals
        //Expected list size: 0
        foodsFilteredList = caloriesFilter.filterByCalories(unfilteredFoods,500, 600);
        System.out.println("Foods with calories that range from 500 to 600: ");
        for(int i = 0; i < foodsFilteredList.size(); i++)
        {
            System.out.println(foodsFilteredList.get(i).toString());
        }
        System.out.println("List size: " + foodsFilteredList.size());
        System.out.println();
    }

    @Test
    public void sortAscendingTest()
    {
        //Food list before sorting
        System.out.println("ASCENDING ORDER \nList before sorting: ");
        for(int i = 0; i < unfilteredFoods.size(); i++)
        {
            System.out.println(unfilteredFoods.get(i).toString());
        }
        System.out.println();

        ArrayList<Food> ascendingList = caloriesFilter.sortAscending(unfilteredFoods);

        //Food list after sorting
        System.out.println("List after sorting: ");
        for(int i = 0; i < ascendingList.size(); i++)
        {
            System.out.println(ascendingList.get(i).toString());
        }
        System.out.println();
    }

    @Test
    public void sortDescendingTest()
    {
        //Food list before sorting
        System.out.println("DESCENDING ORDER \n List before sorting: " );
        for(int i = 0; i < unfilteredFoods.size(); i++)
        {
            System.out.println(unfilteredFoods.get(i).toString());
        }
        System.out.println();

        ArrayList<Food> descendingList = caloriesFilter.sortDescending(unfilteredFoods);

        //Food list after sorting
        System.out.println("List after sorting: ");
        for(int i = 0; i < descendingList.size(); i++)
        {
            System.out.println(descendingList.get(i).toString());
        }
        System.out.println();
    }

    //checks to see if each food is in the caloric range defined
    //true if it does fall within range, false otherwise.
    @Test
    public void applyTest()
    {
        //used to keep track of foods that return true after the apply() method
        int listSize = 0;

        //sets range from 0-100
        //Expected number of foods within this range: 13
        caloriesFilter.filterByCalories(unfilteredFoods, 0, 100);
        //true if it's within defined range, false otherwise
        System.out.println("Range set from 0 - 100:");
        for(int i = 0; i < unfilteredFoods.size(); i++)
        {
            System.out.println(unfilteredFoods.get(i).getName() + " within range? \t\t" + caloriesFilter.apply(unfilteredFoods.get(i)));
            //increase list by one if food item caloric value falls within range
            if(caloriesFilter.apply(unfilteredFoods.get(i)))
            {
                listSize++;
            }
        }
        System.out.println("Number of Foods that fall within this range: " + listSize);
        //resets listSize for next range test
        listSize = 0;
        System.out.println();

        //sets range from 450-600
        //Expected number of foods within this range: 0
        caloriesFilter.filterByCalories(unfilteredFoods, 450, 600);
        System.out.println("Range set from 450 - 600:");
        for(int i = 0; i < unfilteredFoods.size(); i++)
        {
            System.out.println(unfilteredFoods.get(i).getName() + " within range? \t\t" + caloriesFilter.apply(unfilteredFoods.get(i)));
            //increase list by one if food item caloric value falls within range
            if(caloriesFilter.apply(unfilteredFoods.get(i)))
            {
                listSize++;
            }
        }
        System.out.println("Number of Foods that fall within this range: " + listSize);
        //resets listSize for next range test
        listSize = 0;
        System.out.println();

        //sets range from 0-600
        //Expected number of foods within this range: 27
        //everything should be true
        caloriesFilter.filterByCalories(unfilteredFoods, 0, 600);
        System.out.println("Range set from 450 - 600:");
        for(int i = 0; i < unfilteredFoods.size(); i++)
        {
            System.out.println(unfilteredFoods.get(i).getName() + " within range? \t\t" + caloriesFilter.apply(unfilteredFoods.get(i)));
            //increase list by one if food item caloric value falls within range
            if(caloriesFilter.apply(unfilteredFoods.get(i)))
            {
                listSize++;
            }
        }
        System.out.println("Number of Foods that fall within this range: " + listSize);
        System.out.println();
    }
}
