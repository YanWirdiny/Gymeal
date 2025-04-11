package com.example.GYMEAL;

import java.util.List;

public class CalorieResponse {
    private double maintenance ;
    private  double gainweight ;
    private List<String> mealPlan ;

    public double getMaintenance() {
        return maintenance;
    }

    public double getGainweight() {
        return gainweight;
    }

    public void setGainweight(double gainweight) {
        this.gainweight = gainweight;
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
