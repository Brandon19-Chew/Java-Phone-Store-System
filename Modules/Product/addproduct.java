package Modules.Product;

import Classes.Product;
import Utility.IO;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class addproduct {

    // File to store Product details
    File productFile = new File("src/Resource_File/ProductDisplay.txt");

    // Method to save Product details to the file
    public void saveProduct(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(productFile, true))) {
            writer.write(product.toString());
            writer.newLine(); // Add a new line after each Product
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to check if a Product ID already exists in the file
    public boolean isProductIdDuplicate(String productId) {
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get("src/Resource_File/ProductDisplay.txt"));
            for (String line : lines) {
                // Check if the line contains the entered Product ID
                if (line.contains("Product ID: " + productId + ",")) {
                    return true; // Duplicate found
                }
            }
        } catch (IOException e) {
            // If file not found or unable to read, we assume no duplicates
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return false; // No duplicate found
    }

    public static void addProduct() {
        addproduct display = new addproduct();
        String continueInput = "y";

        while ("y".equalsIgnoreCase(continueInput)) {
            String productId;
            boolean isDuplicate;

            // Loop until the user enters a unique Product ID
            do {
                System.out.print("Enter Product ID: ");
                productId = IO.getScanner().nextLine();

                // Check if the Product ID is a duplicate
                isDuplicate = display.isProductIdDuplicate(productId);
                if (isDuplicate) {
                    System.out.println("Error: Product ID already exists. Please enter a different Product ID.");
                }
            } while (isDuplicate);

            // Get other Product details from the user
            System.out.print("Enter Product Name: ");
            String productName = IO.getScanner().nextLine();

            System.out.print("Enter Price: RM ");
            double price = Double.parseDouble(IO.getScanner().nextLine());

            // Create a Product object
            Product product = new Product(productId, productName, price);

            // Save the Product to the file
            display.saveProduct(product);

            System.out.println("Product saved to the file successfully.");

            // Ask if the user wants to add another Product
            System.out.print("Do you want to add another product? (y/n): ");
            continueInput = IO.getScanner().nextLine();
        }

        System.out.println("Thank you! All products have been saved.");
    }
}



