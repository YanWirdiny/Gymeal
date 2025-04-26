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

    //        VARIABLES
    public ReadCSV readCSV = new ReadCSV();  
    public ArrayList<Food> unfilteredFoodList = readCSV.readDataCSV();  
           
    CategoryFilter categoryFilter = new CategoryFilter();

           
    public ArrayList<Food> sortUnfiltered() {
        
        // create new array to store sorted elements
                ArrayList<Food> filteredList = new ArrayList<>();

        // create 5 different arrays for each category and sort them by their categories
        ArrayList<Food> meatList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.MEAT);
        ArrayList<Food> fruitList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.FRUIT);
        ArrayList<Food> vegetableList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.VEGETABLE);
        ArrayList<Food> grainList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.GRAINS);
        ArrayList<Food> drinkList = categoryFilter.filterByCategory(unfilteredFoodList, CategoryFilter.Category.DRINKS);

        // add all category arrays to the final array which will now contain all
        // the elements from the ReadCSV array but in sorted order by category and
        // return the final array
        filteredList.addAll(meatList);
        filteredList.addAll(fruitList);
        filteredList.addAll(vegetableList);
        filteredList.addAll(grainList);
        filteredList.addAll(drinkList);

        return filteredList;


        //METHODS
    }
}

  
    

    
  
    

           
      
     
     
    

    
 
