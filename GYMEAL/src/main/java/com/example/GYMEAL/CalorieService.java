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

        String goal = request.getGoal();
        double DefaultTargetCalories = request.getMaintenance();
        // update default calories
        if ("deficit".equals(goal)) {
            DefaultTargetCalories = request.getModerateDeficit(); // pick based on logic
        } else if ("gain".equals(goal)) {
            DefaultTargetCalories = request.getModerateGain(); // pick based on logic
        }
        List<String> mealPlan = filterMealsFromCSV(DefaultTargetCalories, request.getProtein()); // function to be creeated and  filter  meal  acordingly
//
        CalorieResponse response = new CalorieResponse();
        response.setMaintenance(DefaultTargetCalories);
        response.setMealPlan(mealPlan);
        return response;
        // can add a new list for gaining 500 calories more

    }

    private List<String> filterMealsFromCSV(double DefaultTargetCalories, double targetprotein) {
//         return list of  string where protein   of each element is added  to be equal  to final
//          target calories

        return null ;
    }
}
