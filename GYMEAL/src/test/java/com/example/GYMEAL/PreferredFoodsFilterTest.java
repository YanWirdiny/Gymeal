package com.example.GYMEAL;

import Filters.PreferredFoodsFilter;
import org.junit.jupiter.api.Test;
import Filters.Food;
import java.util.ArrayList;

public class PreferredFoodsFilterTest {
    // create PreferredFoodsFilter as an object
    PreferredFoodsFilter preferredFoodsFilter = new PreferredFoodsFilter();

    // method to test PreferredFoodsFilter
    @Test
    public void preferredFilterTest() {
        // set preferred food to "StEaK"
        preferredFoodsFilter.setPreferredFood("StEaK");
        // create dummy array
        ArrayList<Food> dummylist = new ArrayList<>();
        // add foods to dummy array
        Food newfood1 = new Food("steak", 400, 300, 200, 100, "meat");
        Food newfood2 = new Food("berry", 300, 200, 100, 200, "meat");
        Food newfood3 = new Food("fries and steak", 40, 30, 20, 10, "meat");
        dummylist.add(newfood1);
        dummylist.add(newfood2);
        dummylist.add(newfood3);
        //print filtered dummy array
        System.out.println(preferredFoodsFilter.preferredFilter("steak", dummylist));
    }
}
