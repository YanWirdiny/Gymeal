package com.example.GYMEAL;

import org.junit.jupiter.api.Test;
import Filters.*;
import java.util.ArrayList;
import static Filters.CategoryFilter.Category.*;

public class CategoryFilterTests {

    ArrayList<Food> foods = new ArrayList<>();
    CategoryFilter catFilter = new CategoryFilter();

    //This test is used to make sure that Food objects are properly added to the list
    @Test
    public void addFood()
    {
        foods.add(new Food("Chicken", 200, 30.0, 1.0, 1.0, "meat"));
        foods.add(new Food("Lettuce", 100, 1.0, 5.0, 0.0, "vegetable"));
        foods.add(new Food("Peach", 80, 0.0, 3.0, 4.0, "fruit"));
        foods.add(new Food("Rice", 75, 3.0, 20, 1.0, "grains"));
        foods.add(new Food("Gatorade", 150, 0.0, 2.0, 3.0, "drinks"));
        foods.add(new Food("Steak", 350, 39.0, 4.0, 5.0, "meat"));
    }

    //tests the stringToEnum() method. All categories should be in uppercase to match the enums defined in CategoryFilter class
    @Test
    public void stringToEnumTest()
    {
        addFood();

        System.out.println("ENUM value of 1st food in list: " + catFilter.stringToEnum(foods.get(0)));
        System.out.println("ENUM value of 2nd food in list: " + catFilter.stringToEnum(foods.get(1)));
        System.out.println("ENUM value of 3rd food in list: " + catFilter.stringToEnum(foods.get(2)));
        System.out.println("ENUM value of 4th food in list: " + catFilter.stringToEnum(foods.get(3)));
        System.out.println("ENUM value of 5th food in list: " + catFilter.stringToEnum(foods.get(4)));
        System.out.println("ENUM value of 6th food in list: " + catFilter.stringToEnum(foods.get(5)));
    }

    //tests the apply() and setCategory() methods. After choosing a category, this test checks every Food object
    //in the ArrayList to see if it matches the chosen category. True if it does, false otherwise.
    @Test
    public void applyTest()
    {
        addFood();

        //category = MEAT
        catFilter.setCategory(MEAT);
        System.out.println("Category set to: MEAT");
        for(int i = 0; i < foods.size(); i++)
        {
            System.out.println(foods.get(i).getName() + " is a type of meat?\t\t" + catFilter.apply(foods.get(i)));
        }
        System.out.println();

        //category = FRUIT
        catFilter.setCategory(FRUIT);
        System.out.println("Category set to: FRUIT");
        for(int i = 0; i < foods.size(); i++)
        {
            System.out.println(foods.get(i).getName() + " is a type of fruit?\t\t" + catFilter.apply(foods.get(i)));
        }
        System.out.println();

        //category = VEGETABLE
        catFilter.setCategory(VEGETABLE);
        System.out.println("Category set to: VEGETABLE");
        for (Food food : foods) {
            System.out.println(food.getName() + " is a type of vegetable?\t\t" + catFilter.apply(food));
        }
        System.out.println();

        //category = GRAINS
        catFilter.setCategory(GRAINS);
        System.out.println("Category set to: GRAINS");
        for(int i = 0; i < foods.size(); i++)
        {
            System.out.println(foods.get(i).getName() + " is a type of grain?\t\t" + catFilter.apply(foods.get(i)));
        }
        System.out.println();

        //category = DRINKS
        catFilter.setCategory(DRINKS);
        System.out.println("Category set to: DRINKS");
        for(int i = 0; i < foods.size(); i++)
        {
            System.out.println(foods.get(i).getName() + " is a type of drink?\t\t" + catFilter.apply(foods.get(i)));
        }
        System.out.println();
    }

    //tests filterByCategory() method.
    @Test
    public void filterByCategoryTest()
    {
        addFood();

        //contains list of foods based off of category type
        ArrayList<Food> filteredList;

        //filters list by MEAT
        filteredList = catFilter.filterByCategory(foods, MEAT);
        //prints all foods with category MEAT
        System.out.println("List of foods categorized by 'MEAT': ");
        for(int i = 0; i < filteredList.size(); i++)
        {
            System.out.println(filteredList.get(i).toString());
        }
        System.out.println();

        //filters list by FRUIT
        filteredList = catFilter.filterByCategory(foods, FRUIT);
        //prints all foods with category FRUIT
        System.out.println("List of foods categorized by 'FRUIT': ");
        for(int i = 0; i < filteredList.size(); i++)
        {
            System.out.println(filteredList.get(i).toString());
        }
        System.out.println();

        //filters list by VEGETABLE
        filteredList = catFilter.filterByCategory(foods, VEGETABLE);
        //prints all foods with category VEGETABLE
        System.out.println("List of foods categorized by 'VEGETABLE': ");
        for(int i = 0; i < filteredList.size(); i++)
        {
            System.out.println(filteredList.get(i).toString());
        }
        System.out.println();

        //filters list by GRAINS
        filteredList = catFilter.filterByCategory(foods, GRAINS);
        //prints all foods with category GRAINS
        System.out.println("List of foods categorized by 'GRAINS': ");
        for(int i = 0; i < filteredList.size(); i++)
        {
            System.out.println(filteredList.get(i).toString());
        }
        System.out.println();

        //filters list by DRINKS
        filteredList = catFilter.filterByCategory(foods, DRINKS);
        //prints all foods with category DRINKS
        System.out.println("List of foods categorized by 'DRINKS': ");
        for(int i = 0; i < filteredList.size(); i++)
        {
            System.out.println(filteredList.get(i).toString());
        }
        System.out.println();
    }
}
