/* ReadCSV Class
 * Purpose: this class extracts data from a CSV file found in the 'resources' package and stores the values in each
 * line into a Food object. The Food object is then added to an ArrayList. This code was modified from 'jamesemery64'
 * version of 'ReadCSV' where I first moved the class into a different package, removed the 'Node' subclass and every
 * instance of 'Node' was replaced with a 'Food' instance.
 * NOTE: I couldn't get the 'ReadCSV' file that 'jamesemery64' created for some reason (even after multiple modifications
 * so that it would be compatible for everyone working on the project). I had to delete the class he created. All
 * the code within this class was written by 'jamesemery64' except for the following modifications:
 * line 21 - changed 'main' method into 'readDataCSV'
 * line 24 - ArrayList of 'Node' changed to ArrayList of 'Food'
 * line 32 - used 'InputStream' instead of 'FileReader'; reasons stated below.
 * */

package CSV;

import Filters.Food;

import java.io.*;
import java.util.ArrayList;
public class ReadCSV {

    //All data from CSV file is stored into this ArrayList
    public ArrayList<Food> foodList = new ArrayList<Food>();

    //traverses through the CSV file and stores information into 'Food' objects. Returns an ArrayList of foods.
    public ArrayList<Food> readDataCSV()
    {
        /* use of this Class ensures that we don't have to define a specific file path to find the CSV file (i.e. defining
         * the path as "C:\\Users\\admin\\Downloads\\data.csv" is not optimal). Instead, we store 'data.csv' in our
         * 'resources' package, and we set it as our parameter for method getResourceAsStream(). This tells the program
         * to check our resources folder for the file we give it. NullPointerException is thrown if it can't find
         * the given file.
         * */
        InputStream path = ReadCSV.class.getClassLoader().getResourceAsStream("static/data.csv");

        String line = "";

        /* temporary variables that will hold current node values as it traverses through the list found in the CSV file
         * This is how the constructor for a new Food object takes in its parameters:
         *
         * new Food(String name, int calories, double protein, double carbs, double fats, String category);
         *
         * Compared to how the data is organized in the CSV file:
         *
         * Food,Calories,Fat,Protein,Carbohydrate,Category
         */
        String foodName;
        int calories;
        double protein;
        double carbs;
        double fats;
        String category;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(path))) {
            br.readLine();      //'skips' over the header line containing names of variables

            //ensures all lines in CSV file are read
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                foodName = values[0];
                calories = Integer.parseInt(values[1]);
                protein = Double.parseDouble(values[3]);
                carbs = Double.parseDouble(values[4]);
                fats = Double.parseDouble(values[2]);
                category = values[5];

                Food food = new Food(foodName, calories, protein, carbs, fats, category);
                foodList.add(food);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodList;
    }
}
