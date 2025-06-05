package Modules.Product;

import Utility.IO;
import java.io.*;
import java.util.*;

public class deleteproduct {

    
    public static void deleteProductById(String productId) {
        File inputFile = new File("src/Resource_File/ProductDisplay.txt");
        List<String> products = new ArrayList<>();
        boolean productFound = false;

        productId = productId.trim();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String currentLine;

        
            while ((currentLine = reader.readLine()) != null) {
               
                String[] productDetails = currentLine.split(",\\s*");

               
                if (productDetails.length >= 1 && productDetails[0].equals(productId)) {
                  
                    productFound = true;
                } else {
                    
                    products.add(currentLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return; 
        }

        
        if (productFound) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
                for (String product : products) {
                    writer.write(product);
                    writer.newLine(); 
                }
                System.out.println("Product with ID " + productId + " deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

  
    public static void deleteCategory() {
        System.out.print("Enter the Product ID to delete: ");
        String productId = IO.getScanner().nextLine(); 

       
        if (productId == null || productId.trim().isEmpty()) {
            System.out.println("Product ID cannot be empty.");
            return;
        }

        
        deleteProductById(productId);
    }
}
