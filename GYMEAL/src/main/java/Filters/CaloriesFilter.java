/* CaloriesFilter Class
 * PURPOSE: a filter that implements Filter<T> so that the foods are picked based off of their calories. We can
 * create a method that takes two int values as its parameters (i.e. maxCal & minCal) so that we can extract foods
 * that fall within that range.
 * */
package Filters;
public class CaloriesFilter implements Filter<Food>{

    private int minCals;
    private int maxCals;
    //Constructor
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

    //takes a Food object, extracts caloric value of the food and compares it to the
    //min and max value defined either by default or by the user.
    @Override
    public boolean apply(Food foodItem) {
        int calories = foodItem.getCalories();
        return (calories >= minCals) && (calories <= maxCals);
    }
}
