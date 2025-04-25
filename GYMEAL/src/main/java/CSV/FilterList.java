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
    //replace with unfilteredFoodList.size()
    private final int unfilteredListSize = unfilteredFoodList.size();        //size of unfiltered list

    //METHODS
}
