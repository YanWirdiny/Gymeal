/* FoodTest Class
 * Purpose: test's the methods of the Food class. Food objects are stored in an ArrayList and
 * ideally, we want to be able to access specific Food objects within the ArrayList. Getter and
 * setter methods are also tested.
 * */
package com.example.GYMEAL;

import Filters.Food;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FoodTests {
    public ArrayList<Food> foods = new ArrayList<>();

    //This test is used to make sure that Food objects are properly added to the list
    @Test
    public void addFood()
    {
        foods.add(new Food("Chicken", 200, 30.0, 1.0, 1.0, "meats"));
        foods.add(new Food("Lettuce", 100, 1.0, 5.0, 0.0, "vegetables"));
        foods.add(new Food("Peach", 80, 0.0, 3.0, 4.0, "fruits"));
        foods.add(new Food("Rice", 75, 3.0, 20, 1.0, "grains"));
        foods.add(new Food("Gatorade", 150, 0.0, 2.0, 3.0, "drinks"));
    }

    //Tests all getter methods within the Food class
    @Test
    public void getFoodInfo()
    {
        addFood();
        System.out.println("1st Food object name: " + foods.get(0).getName());          //i=0; "Chicken"
        System.out.println("2nd Food object calories: " + foods.get(1).getCalories());  //i=1; 100
        System.out.println("3rd Food object protein: " + foods.get(2).getProtein());    //i=2; 0.0
        System.out.println("4th Food object carbs: " + foods.get(3).getCarbs());        //i=3; 20.0
        System.out.println("5th Food object fats: " + foods.get(4).getFats());          //i=4; 3.0
        System.out.println("3rd Food object category: " + foods.get(2).getCategory());  //i=2; "fruits"
    }

    //Tests all setter methods within the Food class
    @Test
    public void setFoodInfo()
    {
        addFood();
        printFoods();
        foods.get(0).setName("Steak");
        foods.get(1).setCalories(90);
        foods.get(2).setProtein(1.0);
        foods.get(3).setCarbs(23);
        foods.get(4).setFats(0.0);
        foods.get(4).setCategory("fruits");

        System.out.println();
        printFoods();
    }

    @Test
    public void printFoods()
    {
        System.out.println("List of Foods: ");
        for(int i = 0; i < foods.size(); i++)
        {
            System.out.println(foods.get(i).toString());
        }
    }

}
