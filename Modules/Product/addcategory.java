package Modules.Product;

import Classes.Category;
import Utility.IO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class addcategory {

    private List<Category> categories = new ArrayList<>();
    private final String filePath = "src/Resource_File/CategoryList.txt"; // Path to your text file

    public void addCategoryFromInput() {
        System.out.print("Enter category ID: ");
        String categoryId = IO.getScanner().nextLine();
        
        System.out.print("Enter category name: ");
        String categoryName = IO.getScanner().nextLine();
        
        System.out.print("Enter category description: ");
        String description = IO.getScanner().nextLine();
        
        Category newCategory = new Category(categoryId, categoryName, description);
        categories.add(newCategory);
        
        System.out.println("Category added successfully!");
        
        // Save categories to file
        saveCategoriesToFile();
    }

    public List<Category> getCategories() {
        return categories;
    }

    private void saveCategoriesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Category cat : categories) {
                writer.write(cat.getCategoryId() + "," +
                             cat.getCategoryName() + "," +
                             cat.getDescription());
                writer.newLine();
            }
            System.out.println("Categories saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCategoriesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            categories.clear(); // Clear the current list
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    String description = parts[2];
                    categories.add(new Category(id, name, description));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewCategory() {
        addcategory categoryManager = new addcategory();
        
        // Load existing categories from the file
        categoryManager.loadCategoriesFromFile();
        
        // Example of adding a category through user input
        categoryManager.addCategoryFromInput();
        
        // Print added categories
        System.out.println("Current categories:");
        for (Category cat : categoryManager.getCategories()) {
            System.out.println("ID: " + cat.getCategoryId() +
                               ", Name: " + cat.getCategoryName() +
                               ", Description: " + cat.getDescription());
        }
    }
}
