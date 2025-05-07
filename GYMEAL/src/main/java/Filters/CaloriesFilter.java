/* CaloriesFilter Class
 * PURPOSE: a filter that implements Filter<T> so that the foods are picked based off of their calories. Includes
 * a method that takes two int values as its parameters (i.e. maxCal & minCal) so that we can extract foods
 * within that range.
 * */
package Filters;

import java.util.ArrayList;
 import java.util.List;

public class CaloriesFilter implements Filter<Food>{

    private int minCals;
    private int maxCals;
    //Constructor

    //FIXME: consider removing default constructor
    //default constructor
    public CaloriesFilter()
    {
        minCals = 0;
        maxCals = 5000;
    }

    //constructor where user defines the range of calories they want
    public CaloriesFilter(int min, int max)
    {
        minCals = min;
        maxCals = max;
    }

    //method that alters caloric range only accessible from filterByCalories() method
    private void setRange(int min, int max)
    {
        minCals = min;
        maxCals = max;
    }

    //method that returns a filtered food list based off of a caloric range
    //this method DOES NOT order them from the largest value to the smallest value or vice-versa.
    //we can use another method to do that (using QuickSort, RadixSort, etc.)
    public ArrayList<Food> filterByCalories(List<Food> unfilteredList, int min, int max)
    {
        //calories filter
        //list that contains filtered foods based of caloric range
        ArrayList<Food> filteredList = new ArrayList<>();

        //sets to specific range given by parameters
        setRange(min, max);

        //used to traverse unfiltered food list
        for(int i = 0; i < unfilteredList.size(); i++)
        {
            //if food at index i (where 0 <= i < unfilteredListSize) falls withing specified range, add to filtered list
            if(apply(unfilteredList.get(i)))
            {
                filteredList.add(unfilteredList.get(i));
            }
            //otherwise, do not add the food to the list (do nothing)
        }
        return filteredList;
    }

    //takes a Food object, extracts caloric value of the food and compares it to the
    //min and max value defined either by default or by the user.
    @Override
    public boolean apply(Food foodItem) {
        int calories = foodItem.getCalories();
        return (calories >= minCals) && (calories <= maxCals);
    }
}
