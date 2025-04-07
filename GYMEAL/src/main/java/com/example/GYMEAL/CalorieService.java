package com.example.GYMEAL;
import  com.example.GYMEAL.CalorieDataRequest;
import com.example.GYMEAL.CalorieResponse;
import  org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class CalorieService {
    //  Where to  work  with the response  and  CSv filtering
//     and    search  algorithmn\

    public CalorieResponse processCalorieData(CalorieDataRequest request) {
        // Example: Use maintenance calorie target for filtering meals.
        double targetCalories = request.getMaintenance();
        List<String> mealPlan = filterMealsFromCSV(targetCalories, request.getProtein()); // function to be creeated and  filter  meal  acordingly

        CalorieResponse response = new CalorieResponse();
        response.setMaintenance(targetCalories);
        response.setMealPlan(mealPlan);
        return response;
    }

    private List<String> filterMealsFromCSV(double targetCalories, double targetprotein) {
//         return list of  string where protein   of each element is added  to be equal  to final
//          target calories

        return null ;
    }
}
