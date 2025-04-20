/* FilterList Class
 * Purpose: This class is where filtered lists are generated using any class that implements the Filter interface. The
 * food list is generated from the CSV file found in 'resources' and stored as a global variable.
 * NTS: consider putting these methods into the specific filters themselves to avoid the use of various ArrayLists.
 * */
package CSV;

import Filters.CaloriesFilter;
import Filters.Filter;
import Filters.Food;
import java.util.ArrayList;

public class FilterList {

    //VARIABLES
    public ReadCSV readCSV = new ReadCSV();        //generates unfiltered list of foods
    public ArrayList<Food> unfilteredFoodList = readCSV.readDataCSV();      //unfiltered list
    private final int unfilteredListSize = readCSV.foodListSize();        //size of unfiltered list

    //METHODS

    //method that returns a filtered food list based off of a caloric range
    //this method DOES NOT order them from the largest value to the smallest value or vice-versa.
    //we can use another method to do that (using QuickSort, RadixSort, etc.)
    public ArrayList<Food> filterByCalories(int min, int max)
    {
        //calories filter
        Filter<Food> caloriesFilter = new CaloriesFilter(min, max);
        //list that contains filtered foods based of caloric range
        ArrayList<Food> filteredList = new ArrayList<>();

        //used to traverse unfiltered food list
        for(int i = 0; i < unfilteredListSize; i++)
        {
            //if food at index i (where 0 <= i < unfilteredListSize) falls withing specified range, add to filtered list
            if(caloriesFilter.apply(unfilteredFoodList.get(i)))
            {
                filteredList.add(unfilteredFoodList.get(i));
            }
            //otherwise, do not add the food to the list (do nothing)
        }
        return filteredList;
    }
}
