package com.example.GYMEAL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalorieServiceTest {


   private CalorieService calorieService;

   @BeforeEach
    void setUp(){
       calorieService = new CalorieService();

   }
   @Test
    void TestFilterMealsFromCSV_ReturnsMealInRange(){
       double targetCalories = 500 ;
       double targetProtein = 0;
       List<String> mealPlan = calorieService.filterMealsFromCSV(targetCalories, targetProtein);
       assertNotNull(mealPlan, " man your stuff is empty");
       assertFalse(mealPlan.isEmpty(), " Meal plan should not empty");




   }

}
