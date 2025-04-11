package com.example.GYMEAL;

import java.util.List;

public class CalorieResponse {
    private double maintenance ;

    //SUGGESTION: instead of a 'String' list, how about we replace it with a 'Food' list? We would have to obviously
    //create a 'Food' class with the basic info that we need (calories, protein, carbs, fats, etc.). From this class,
    //we can extract the name of the food PLUS additional data about the food I mentioned.
    private List<String> mealPlan ;

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    public List<String> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(List<String> mealPlan) {
        this.mealPlan = mealPlan;
    }
}
