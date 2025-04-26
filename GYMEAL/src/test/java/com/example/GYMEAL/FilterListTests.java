/* Tests for FilterList Class
 * Purpose: tests for methods found in the FilterList class.
 * */

package com.example.GYMEAL;

import CSV.FilterList;
import Filters.Food;
import Filters.CategoryFilter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class FilterListTests {
    // create FilterList object
    FilterList filterList = new FilterList();
    // create array for filtered list
    ArrayList<Food> filteredList = new ArrayList<>();

    @Test
    public void FilterList() {
        // test sortUnfiltered()
        filteredList = filterList.sortUnfiltered();
        System.out.println(filteredList.toString());
    }

}
