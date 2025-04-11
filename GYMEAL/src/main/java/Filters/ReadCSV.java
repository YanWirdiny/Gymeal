import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Node {
    int calorie;
    String food;
    double fat;
    double protein;
    double carbohydrates;
    String category;

    public Node(String food, int calorie, double fat, double protein, double carbohydrates, String category) {
        this.food = food;
        this.calorie = calorie;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.category = category;
        this.fat = fat;

    }
}


public class ReadCSV {
    public static void main(String[] args) {
        String path = "C:\\Users\\admin\\Downloads\\data.csv";
        String line = "";
        ArrayList<Node> csvlist = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int calorie = Integer.parseInt(values[1]);
                double fat = Double.parseDouble(values[2]);
                double protein = Double.parseDouble(values[3]);
                double carbohydrates = Double.parseDouble(values[4]);
                Node node = new Node(values[0], calorie, fat, protein, carbohydrates, values[5]);
                csvlist.add(node);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

}





}