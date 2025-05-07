package com.example.GYMEAL;

import Filters.CaloriesFilter;
import Filters.Food;
import  org.springframework.stereotype.Service;
import Filters.CategoryFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalorieService {
    //  Where to  work  with the response  and  CSv filtering
//     and    search  algorithmn\

    public CalorieResponse processCalorieData(CalorieDataRequest request) {
        double DefaultTargetCalories;

        // Pick calorie target based on goal
        switch (request.getGoal()) {
            case "deficit":
                DefaultTargetCalories = request.getMildDeficit();
                break;
            case "moderateDeficit":
                DefaultTargetCalories = request.getModerateDeficit();
                break;
            case "aggressiveDeficit":
                DefaultTargetCalories = request.getAggressiveDeeficit();
                break;
            case "gain":
                DefaultTargetCalories = request.getMildGain();
                break;
            case "moderateGain":
                DefaultTargetCalories = request.getModerateGain();
                break;
            case "aggressiveGain":
                DefaultTargetCalories = request.getAggressiveGain();
                break;
            default:
                DefaultTargetCalories = request.getMaintenance();
        }

        double targetProtein = request.getProtein();

        List<Food> filtered = filterMealsFromCSV(DefaultTargetCalories);

        CalorieResponse response = new CalorieResponse();
        response.setMaintenance(DefaultTargetCalories);
        response.setMealPlan(filtered);

        return response;
    }




    public List<Food> filterMealsFromCSV(double DefaultTargetCalories) {
//         return list of  string where protein   of each element is added  to be equal  to final
//          target calories
        /* 1.  Read CSV (unchanged column order) -------------------- */
        List<Food> allFoods = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/foods.csv"))) {

            br.readLine();                        // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length >= 6) {
                    allFoods.add(new Food(
                            p[0].trim(),                          // Food
                            Integer.parseInt(p[1].trim()),        // Calories
                            Double.parseDouble(p[3].trim()),      // Protein
                            Double.parseDouble(p[4].trim()),      // Carbohydrate
                            Double.parseDouble(p[2].trim()),      // Fat
                            p[2].trim()                           // Category  (unchanged)
                    ));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading food data", e);
        }


        Random rand = new Random();
        List<Food> mealPlan = new ArrayList<>();
        HashSet<String> pickedNames = new HashSet<>();

        while (mealPlan.size() < 5) {
            Food pick = allFoods.get(rand.nextInt(allFoods.size()));
            if (pickedNames.add(pick.getName())) {   // uniqueness by food name
                mealPlan.add(pick);
            }
        }


        int lower = (int) (DefaultTargetCalories - 200);
        int upper = (int) (DefaultTargetCalories + 200);

        int total = mealPlan.stream()
                .mapToInt(Food::getTotalCalories)
                .sum();                       // uses servings

        while (total < lower) {
            // add ONE extra serving to one of the existing five foods
            Food f = mealPlan.get(rand.nextInt(mealPlan.size()));
            f.addServing();
            total += f.getCalories();                    // +1 serving

            if (total > upper) break;
        }


        CaloriesFilter  filtered = new CaloriesFilter(0 ,upper);
            return filtered.filterByCalories(mealPlan, 0 ,upper);
    }

}
