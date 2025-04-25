package com.example.GYMEAL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalorieController {
    @Autowired
    private CalorieService calorieService;

    // Place for different endpoint
    @GetMapping("/calculate")
    public  CalorieResponse processCalorieData( @RequestParam(defaultValue = "2000") double maintenance,
                                                @RequestParam(defaultValue = "1800") double mildDeficit,
                                                @RequestParam(defaultValue = "1500") double moderateDeficit,
                                                @RequestParam(defaultValue = "1200") double aggressiveDeeficit,
                                                @RequestParam(defaultValue = "2200") double mildGain,
                                                @RequestParam(defaultValue = "2500") double moderateGain,
                                                @RequestParam(defaultValue = "2800") double aggressiveGain,
                                                @RequestParam(defaultValue = "100") double protein,
                                                @RequestParam(defaultValue = "normal") String bmi,
                                                @RequestParam(defaultValue = "deficit") String goal ) {
        CalorieDataRequest request = new CalorieDataRequest();
        request.setMaintenance(maintenance);
        request.setMildDeficit(mildDeficit);
        request.setModerateDeficit(moderateDeficit);
        request.setAggressiveDeeficit(aggressiveDeeficit);
        request.setMildGain(mildGain);
        request.setModerateGain(moderateGain);
        request.setAggressiveGain(aggressiveGain);
        request.setProtein(protein);
        request.setBmi(bmi);
        request.setGoal(goal);
        return  calorieService.processCalorieData(request);
    }
    //
}
