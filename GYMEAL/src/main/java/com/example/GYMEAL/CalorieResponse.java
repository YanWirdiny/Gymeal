package com.example.GYMEAL;

import Filters.Food;
import java.util.List;

public class CalorieResponse {
    private double maintenance;
    private double proteinTarget;
    private String goal;
    private List<Food> mealPlan;

    public double getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(double maintenance) {
        this.maintenance = maintenance;
    }

    public double getProteinTarget() {
        return proteinTarget;
    }

    public void setProteinTarget(double proteinTarget) {
        this.proteinTarget = proteinTarget;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<Food> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(List<Food> mealPlan) {
        this.mealPlan = mealPlan;
    }
}
