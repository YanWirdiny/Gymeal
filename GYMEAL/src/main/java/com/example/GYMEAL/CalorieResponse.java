package com.example.GYMEAL;

import java.util.List;

public class CalorieResponse {
    private double maintenance ;
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
