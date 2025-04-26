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
import Filters.CategoryFilter;
import jdk.jfr.Category;

public class FilterList {

    //VARIABLES
    public ReadCSV readCSV = new ReadCSV();        //generates unfiltered list of foods
    public ArrayList<Food> unfilteredFoodList = readCSV.readDataCSV();      //unfiltered list
    //replace with unfilteredFoodList.size()
    private final int unfilteredListSize = unfilteredFoodList.size();
    //size of unfiltered list
    CategoryFilter categoryFilter = new CategoryFilter();


<<<<<<< Updated upstream

    public ArrayList<Food> sortUnfiltered() {

        ArrayList<Food> filteredList = new ArrayList<>();

        ArrayList<Food> meatList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.MEAT);
        ArrayList<Food> fruitList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.FRUIT);
        ArrayList<Food> vegetableList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.VEGETABLE);
        ArrayList<Food> grainList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.GRAINS);
        ArrayList<Food> drinkList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.DRINKS);

        filteredList.addAll(meatList);
        filteredList.addAll(fruitList);
        filteredList.addAll(vegetableList);
        filteredList.addAll(grainList);
        filteredList.addAll(drinkList);

        return filteredList;


        //METHODS
    }
=======
    //categoryFilter

    //METHODS
>>>>>>> Stashed changes
}
