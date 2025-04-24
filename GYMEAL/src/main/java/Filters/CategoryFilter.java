/* CategoryFilter class
 * Purpose: a filter that's used to sort foods by their categories. Utilizes enums for easier filter implementation. Using
 * these enums and comparing them to a Food object category value determines if said Food object is included in the
 * filtered list.
 * */

package Filters;

import java.util.ArrayList;

public class CategoryFilter implements Filter<Food>{

    //VARIABLES
    private Category category;      //this filters has a variable that will keep track of the category we need to sort by

    //CONSTRUCTOR
    public CategoryFilter() {}

    //ENUMS
    public enum Category
    {
        FRUIT,
        VEGETABLE,
        MEAT,
        GRAINS,
        DRINKS
    }

    //METHODS

    //converts string categories from CSV file into enums that can be used to sort foods
    public Category stringToEnum(Food foodItem)
    {
        try
        {
            //gets food item category string value, trims off any whitespace before or after the string (if any).
            //all letters in the string are converted to uppercase to match enum values.
            String strCat = foodItem.getCategory().trim().toUpperCase();

            //takes category string value and returns an enum if the string is equivalent to any enum constant in Category.
            return Category.valueOf(strCat);
        }
        catch(IllegalArgumentException e)
        {
            return null;
        }
    }

    //filters a given array by one of the five categories and returns a filtered list (by category)
    public ArrayList<Food> filterByCategory(ArrayList<Food> unfilteredList, Category category)
    {
        //filtered list that will be returned containing only foods that match the given category
        ArrayList<Food> filteredList = new ArrayList<>();

        setCategory(category);
        for(int i = 0; i < unfilteredList.size(); i++)
        {
            //add current food object to filtered list if it matches given category
            if(apply(unfilteredList.get(i)))
            {
                filteredList.add(unfilteredList.get(i));
            }
            //otherwise, do nothing
        }
        return filteredList;
    }

    //changes category value
    public void setCategory(Category category)
    {
        this.category = category;
    }

    //compares food category with a Category enum
    @Override
    public boolean apply(Food foodItem) {
        //converts Food category (String type) to an enum
        Category CategoryVal = stringToEnum(foodItem);

        //true if current Food object category is equal to this.category value
        return CategoryVal.equals(this.category);
    }
}
