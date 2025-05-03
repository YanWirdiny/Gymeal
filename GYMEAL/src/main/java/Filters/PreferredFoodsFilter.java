package Filters;

import java.util.ArrayList;
import java.util.Arrays;

public class PreferredFoodsFilter implements Filter<Food>{

    private String preferredFood;

    // create a method that filters out all the foods that contain the
    // preferred food name in their name. This is done by iterating through
    // all food items in the unfiltered list and iterating through all the
    // strings in the food items' names
    public ArrayList<Food> preferredFilter(String preferredfood, ArrayList<Food> unfilteredlist){
        setPreferredFood(preferredfood);
        ArrayList<Food> filteredlist = new ArrayList<>();
        for (int i = 0; i < unfilteredlist.size(); i++){
            Food fooditem = unfilteredlist.get(i);
            if (apply(fooditem)) {
                filteredlist.add(fooditem);
            }
        }

        // if the filtered list is empty, return null. Otherwise, return
        // filtered list
        if (filteredlist.isEmpty()) {
            return null;
        }
        return filteredlist;
    }

    // set the preferred food of this class to the user's input and convert to
    // lowercase
    public void setPreferredFood(String preferredFood){
        this.preferredFood = preferredFood.toLowerCase();
    }


    // checks if the preferred food name is contained in the name of a food item
    @Override
    public boolean apply(Food foodItem) {
        String[] namesOfFood = foodItem.getName().split(this.preferredFood);
        if (namesOfFood.length == 0){
            return true;
        }
        return !namesOfFood[0].equals(foodItem.getName());
    }


}
