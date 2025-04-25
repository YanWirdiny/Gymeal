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
    FilterList filterList = new FilterList();
    ArrayList<Food> filteredList = new ArrayList<>();

    @Test
    public void FilterList() {

        filteredList = filterList.sortUnfiltered();
        System.out.println(filteredList.toString());
    }

}
