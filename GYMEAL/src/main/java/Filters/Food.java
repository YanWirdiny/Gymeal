/* Food Class
 * Purpose: a class that contains the basic nutritional information for some Food object. The idea here
 * is to use this class to generate multiple Food objects and store them in a list. With this class, we
 * can implement filters that can list the foods that we are interested in without having to go back and
 * forth between the database and the lists containing the Food objects.
 * */

package Filters;

import jakarta.persistence.*;

public class Food {

    //Variables

    private final int PER100GRAMS = 100;
    private String name;
    private String category;

    private int calories;

    private double protein;
    private double carbs;
    private double fats;

    //CONSTRUCTORS
    public Food()
    {
        name = "";
        calories = 0;
        protein = 0.0;
        carbs = 0.0;
        fats = 0.0;
        category = "";
    }

    public Food(String name, int calories, double protein, double carbs, double fats, String category)
    {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.category = category;
    }

    //getter methods
    public String getName()
    {
        return name;
    }
    public int getCalories()
    {
        return calories;
    }
    public double getProtein()
    {
        return protein;
    }
    public double getCarbs()
    {
        return carbs;
    }
    public double getFats()
    {
        return fats;
    }
    public String getCategory() {
        return category;
    }

    //setter methods
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCalories(int calories)
    {
        this.calories = calories;
    }
    public void setProtein(double protein)
    {
        this.protein = protein;
    }
    public void setCarbs(double carbs)
    {
        this.carbs = carbs;
    }
    public void setFats(double fats)
    {
        this.fats = fats;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //converts a Food object into a readable String
    @Override
    public String toString() {
        return name + ": [" +
                "Calories: " + calories +
                ", Protein: " + protein +
                ", Carbs: " + carbs +
                ", Fats: " + fats +
                ", Category: " + category +
                ']';
    }
}
