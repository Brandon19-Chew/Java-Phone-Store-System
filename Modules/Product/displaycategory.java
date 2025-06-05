package Modules.Product;

import Classes.Category;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class displaycategory {

    public static void displayCategories(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the file has data in the format: categoryId,categoryName,description
                String[] data = line.split(",");
                if (data.length == 3) {
                    String categoryId = data[0].trim();
                    String categoryName = data[1].trim();
                    String description = data[2].trim();

                    Category category = new Category(categoryId, categoryName, description);
                    System.out.println("Category ID: " + category.getCategoryId());
                    System.out.println("Category Name: " + category.getCategoryName());
                    System.out.println("Description: " + category.getDescription());
                    System.out.println(); // For better readability
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllCategories() {
        String filePath = "src/Resource_File/CategoryList.txt"; // Update this with your file path
        displayCategories(filePath);
    }
}
