/*RadixSort class
 * Purpose: this class was created to be used inside the CaloriesFilter class to sort foods based off of their
 * caloric values either in ascending or descending order.
 * */
package Filters;

import java.util.*;

public class RadixSort {
    // A utility function to get maximum value in arr[]
    public int getMax(ArrayList<Food> foodList)
    {
        //max value set to first element in list
        int max = foodList.get(0).getCalories();

        //traverse through entire list
        for (int i = 1; i < foodList.size(); i++)
            //if current caloric value at position i > max
            if (foodList.get(i).getCalories() > max)
                //set new max to caloric value at position i
                max = foodList.get(i).getCalories();
        return max;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public void countSort(ArrayList<Food> foodList, int exp)
    {
        ArrayList<Food> output = new ArrayList<>(foodList.size()); // output array same size as given array
        int i;
        //array stores the # of elements in each bucket (10 total for each digit from 0-9)
        int[] count = new int[10];
        //populates count[] array with 0 int values
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < foodList.size(); i++)
            count[(foodList.get(i).getCalories() / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        //FIXME: fix issue on line 48
        // Build the output array
        for (i = foodList.size() - 1; i >= 0; i--) {
            output.set(count[(foodList.get(i).getCalories() / exp) %10] - 1, foodList.get(i));
            //output[count[(foodList.get(i).getCalories() / exp) % 10] - 1] = foodList.get(i).getCalories();
            count[(foodList.get(i).getCalories() / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < foodList.size(); i++)
            foodList.set(i, output.get(i));
            //arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    public void radixSort(ArrayList<Food> foodList)
    {
        // Find the maximum number to know number of digits
        int m = getMax(foodList);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(foodList, exp);
    }

    // A utility function to print an array
    public void print(ArrayList<Food> foodList)
    {
        for (int i = 0; i < foodList.size(); i++)
            System.out.print(foodList.get(i) + " ");
    }
}
