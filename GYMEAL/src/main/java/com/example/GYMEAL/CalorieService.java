package com.example.GYMEAL;
import  org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
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

    public List<String> filterMealsFromCSV(double DefaultTargetCalories, double targetprotein) {
//         return list of  string where protein   of each element is added  to be equal  to final
//          target calories
             List<Meal> meals  = new ArrayList<>();
             String line ;
             try(BufferedReader  br = new BufferedReader(new FileReader("src/main/resources/static/data.csv"))) {
                 // skip first line
                 br.readLine();
                 while((line = br.readLine()) != null) {
                     String[] parts = line.split(",");// add part in ana array
                     String name = parts[0].trim();
                     double calories = Double.parseDouble(parts[1].trim());
                     double proteins = Double.parseDouble(parts[3].trim());
                     meals.add(new Meal(name, calories, proteins));

                 }



             } catch (FileNotFoundException e) {
                 throw new RuntimeException(e);
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }

        double calorieSum = 0;
        List<String>  selectedMeals = new ArrayList<>();
        for (Meal meal : meals) {
            if (calorieSum + meal.getCalories() <= DefaultTargetCalories + 50) {
                calorieSum += meal.getCalories();
                selectedMeals.add(meal.getName());
            }
            if (calorieSum >= DefaultTargetCalories - 50) {
                break;
            }
        }



        return selectedMeals ;
    }

    private  static  class  Meal{
        private  String name ;
        private  double calories ;
        private  double protein ;

        public Meal(String name, double calories, double protein) {
            this.name = name;
            this.calories = calories;
            this.protein = protein;
        }

        public String getName() {
            return name;
        }

        public double getCalories() {
            return calories;
        }

        public double getProtein() {
            return protein;
        }
    }
}
