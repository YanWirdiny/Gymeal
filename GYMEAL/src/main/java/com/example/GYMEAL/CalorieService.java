package com.example.GYMEAL;

import Filters.CaloriesFilter;
import Filters.Food;
import  org.springframework.stereotype.Service;
import Filters.CategoryFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
        ArrayList<Food> allFoods = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/data.csv"))) {
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String name = parts[0].trim();
                    int calories = Integer.parseInt(parts[1].trim());
                    double fats = Double.parseDouble(parts[2].trim());
                    double protein = Double.parseDouble(parts[3].trim());
                    double carbs = Double.parseDouble(parts[4].trim());
                    String category = parts[2].trim();
                    allFoods.add(new Food(name, calories, protein, carbs, fats, category));





                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading food data", e);
        }

        // What to do
                    /*

                         i want  to  randomly  pick one element from each  category   add it a new list
                          in this new list<food>  called finalList
                         re-add the same element  form each category  check if we are in range of  <  target -200 ; target+200>
                           if yes return list

                     */


        Map<String, List<Food>> foodsByCategory = allFoods.stream()
                .collect(Collectors.groupingBy(Food::getCategory));

        Random rand = new Random();
        ArrayList<Food> finalList = new ArrayList<>();

        // Step 1: Pick one random food from each category
        for (List<Food> foodsInCategory : foodsByCategory.values()) {
            if (!foodsInCategory.isEmpty()) {
                finalList.add(foodsInCategory.get(rand.nextInt(foodsInCategory.size())));
            }
        }

        // Step 2: Keep adding random foods from any category until total calories are within target range
        int totalCalories = finalList.stream().mapToInt(Food::getCalories).sum();
        while (totalCalories < DefaultTargetCalories - 200) {
            Food randomFood = allFoods.get(rand.nextInt(allFoods.size()));
            finalList.add(randomFood);
            totalCalories += randomFood.getCalories();

            if (totalCalories > DefaultTargetCalories + 200) break;
        }




        CaloriesFilter filter = new CaloriesFilter((int) (0), (int) (DefaultTargetCalories + 200));
        return filter.filterByCalories(finalList, (int) (0), (int) (DefaultTargetCalories + 200));


    }


}
