package com.example.GYMEAL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalorieController {
    @Autowired
    private CalorieService calorieService;

    // Place for different endpoint
    @PostMapping("/calculate")
    public  CalorieResponse processCalorieData(@RequestBody CalorieDataRequest request){
        return  calorieService.processCalorieData(request);
    }
    //
}
