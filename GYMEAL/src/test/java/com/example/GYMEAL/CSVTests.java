package com.example.GYMEAL;

import CSV.ReadCSV;

import org.junit.jupiter.api.Test;

public class CSVTests {

    @Test
    public void testCSVReader()
    {
        ReadCSV reader = new ReadCSV();

        reader.readDataCSV();
    }
}
