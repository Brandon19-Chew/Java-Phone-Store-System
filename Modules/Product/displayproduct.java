package Modules.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Main class
public class displayproduct {

    File productfile = new File("src/Resource_File/ProductDisplay.txt");

    // Method to read and display products from the file
    public void displayProducts() {
        if (!productfile.exists()) {
            System.out.println("The file does not exist or no products have been added yet.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(productfile))) {
            String line;
            System.out.println("Product Details:");

            // Read each line and print it in the desired format
            while ((line = reader.readLine()) != null) {
                // Split the line into parts using comma as a delimiter
                String[] parts = line.split(",");

                // Ensure the line has all necessary parts before formatting
                if (parts.length == 3) {
                    String productId = parts[0].trim();
                    String productName = parts[1].trim();
                    String price = parts[2].trim();

                    // Format and print the output without quantity
                    System.out.printf("ID: %7s || %10s || RM %s%n", productId, productName, price);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void displayAllProduct(){
        displayproduct display = new displayproduct();

        // Display the products
        display.displayProducts();
    }
}
