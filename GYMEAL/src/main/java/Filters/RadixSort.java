/*RadixSort class
 * Purpose: this class was created to be used inside the CaloriesFilter class to sort foods based off of their
 * caloric values either in ascending or descending order.
 * */
package Filters;

import java.util.*;

public class RadixSort {
    // A utility function to get food with maximum caloric value in foodList
    public int getMax(ArrayList<Food> foodList)
    {
        //max value always set to first element in list
        int max = foodList.get(0).getCalories();

        //traverse through entire list
        for (int i = 1; i < foodList.size(); i++){

            //if current caloric value at position i > max
            if (foodList.get(i).getCalories() > max) {
                //set new max to caloric value at position i
                max = foodList.get(i).getCalories();
            }
            //otherwise, leave max unchanged
        }
        return max;
    }

    // A function to do counting sort on foodList according to
    // the digit represented by exp.
    public void countSort(ArrayList<Food> foodList, int exp)
    {
        ArrayList<Food> output = new ArrayList<Food>(); // output array

        //populates the empty ArrayList with 'null' so that 'output' and 'foodList' have the same size
        for(int k = 0; k < foodList.size(); k++)
        {
            output.add(null);
        }

        //array stores the frequency of digits in each bucket (10 buckets total, digits 0-9)
        int[] count = new int[10];
        //populates count[i] with 0
        Arrays.fill(count, 0);

        // Store frequency of occurrences in count[]
        for (int i = 0; i < foodList.size(); i++)
        {
            count[(foodList.get(i).getCalories() / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains actual position of this digit in output
        for (int i = 1; i < 10; i++)
        {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = foodList.size() - 1; i >= 0; i--)
        {
            /* food at index i (which starts at the end of the list) placed in output at index j where:
             * j = ((caloric value/exp) % 10) - 1
             * */
            output.set(count[(foodList.get(i).getCalories() /exp) %10] - 1, foodList.get(i));
            count[(foodList.get(i).getCalories() / exp) % 10]--;
        }

        // Copy the output array to foodList, so that foodList now contains foods sorted by caloric value
        //NOTE: you could simply modify this method so that it returns the output ArrayList
        for (int i = 0; i < foodList.size(); i++)
        {
            foodList.set(i, output.get(i));
        }
    }

    // The main function to that sorts foodList of using Radix Sort
    public void radixSort(ArrayList<Food> foodList)
    {
        // Find the maximum number to know number of digits
        int m = getMax(foodList);

        // Do counting sort for every digit. Note that instead of passing digit number, exp is passed.
        // exp = 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(foodList, exp);
    }

    // A utility function that prints an array
    public void print(ArrayList<Food> foodList)
    {
        for (int i = 0; i < foodList.size(); i++)
            System.out.println(foodList.get(i) + " ");
    }
}
