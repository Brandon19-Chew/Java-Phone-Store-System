package Modules.Product;

import Utility.IO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class deletecategory {

    private static final String FILE_PATH = "src/Resource_File/CategoryList.txt";

    public static void deleteCategory(String categoryId) throws IOException {
      
        List<String> lines = new ArrayList<>();
        boolean categoryFound = false;

      
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*"); 
                if (parts.length >= 1 && parts[0].equals(categoryId)) {
                    categoryFound = true; 
                    continue; 
                }
                lines.add(line); 
            }
        }

       
        if (categoryFound) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, false))) {
                for (String line : lines) {
                    writer.println(line);
                }
            }
            System.out.println("Category with ID " + categoryId + " has been deleted.");
        } else {
            System.out.println("Category with ID " + categoryId + " not found.");
        }
    }

    public static void deleteSelectedCategory() {
        System.out.print("Enter the Category ID to delete: ");
        String categoryId = IO.getScanner().nextLine().trim();

        if (categoryId.isEmpty()) {
            System.out.println("Category ID cannot be empty.");
            return;
        }

        try {
            deleteCategory(categoryId);
        } catch (IOException e) {
            System.err.println("An error occurred while deleting the category: " + e.getMessage());
        }
    }
}
