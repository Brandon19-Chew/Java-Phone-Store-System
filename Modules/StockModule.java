package Modules;

import Classes.Stock;
import Utility.TextColors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import Utility.IO;
import java.util.ArrayList;
import java.util.List;

public class StockModule {

    private static final String FILEPATH = "src/Resource_File/Stocks.txt";

    public static void addStock() {
        TextColors.colors(); // This initializes the color codes

        File finalFile = new File(FILEPATH);

        // Prompt user for stock information
        System.out.print("Enter category: ");
        String category = IO.getScanner().nextLine().trim();

        System.out.print("Enter product ID: ");
        String productID = IO.getScanner().nextLine().trim();

        System.out.print("Enter product name: ");
        String productName = IO.getScanner().nextLine().trim();

        System.out.print("Enter stock quantity: ");
        int quantity = IO.getScanner().nextInt();
        IO.getScanner().nextLine(); // Consume newline

        // Validate if the product ID or product name already exists
        try (BufferedReader reader = new BufferedReader(new FileReader(finalFile))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] stockData = currentLine.split("\\|");

                if (stockData[1].trim().equals(productID)) {
                    System.out.println(TextColors.ANSI_RED + "Error: Product ID '" + productID + "' already exists!" + TextColors.ANSI_RESET);
                    return; // Exit the method if product ID already exists
                }

                if (stockData[2].trim().equalsIgnoreCase(productName)) {
                    System.out.println(TextColors.ANSI_RED + "Error: Product name '" + productName + "' already exists!" + TextColors.ANSI_RESET);
                    return; // Exit the method if product name already exists
                }
            }
        } catch (IOException e) {
            System.out.println(TextColors.ANSI_RED + "Error reading stock file for validation: " + e.getMessage() + TextColors.ANSI_RESET);
            return;
        }

        // Create Stock object with provided data
        Stock stock = new Stock(category, productID, productName, quantity);

         try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalFile, true))) {
            // Write stock data to temp file in pipe-separated format
            writer.write(stock.getCategory() + "|" + stock.getProductID() + "|" + stock.getProductName() + "|" + stock.getQuantity());
            writer.newLine();
            System.out.println(TextColors.ANSI_GREEN + "Stock added successfully to Stocks file!" + TextColors.ANSI_RESET);
        } catch (IOException e) {
            System.out.println(TextColors.ANSI_RED + "Error adding stock to temp file: " + e.getMessage() + TextColors.ANSI_RESET);
           
    }
    }
  public static void updateStock() {
    File finalFile = new File(FILEPATH);

    System.out.print("Enter category: ");
    String category = IO.getScanner().nextLine();

    System.out.print("Enter product ID to update: ");
    String productID = IO.getScanner().nextLine();

    boolean updated = false;
    List<String> fileContent = new ArrayList<>();

    try (
        BufferedReader reader = new BufferedReader(new FileReader(finalFile));
    ) {
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            String[] stockData = currentLine.split("\\|"); // Use pipe as delimiter
            if (stockData.length == 4 && stockData[0].equalsIgnoreCase(category) && stockData[1].equals(productID)) {
                System.out.println("Current details: ");
                System.out.println("Category: " + stockData[0]);
                System.out.println("Product ID: " + stockData[1]);
                System.out.println("Product Name: " + stockData[2]);
                System.out.println("Quantity: " + stockData[3]);

                // Get new details from user
                System.out.print("Enter new category (leave blank to keep unchanged): ");
                String newCategory = IO.getScanner().nextLine();
                if (newCategory.isEmpty()) {
                    newCategory = stockData[0];
                }

                System.out.print("Enter new product ID (leave blank to keep unchanged): ");
                String newProductID = IO.getScanner().nextLine();
                if (newProductID.isEmpty()) {
                    newProductID = stockData[1];
                }

                System.out.print("Enter new product name (leave blank to keep unchanged): ");
                String newProductName = IO.getScanner().nextLine();
                if (newProductName.isEmpty()) {
                    newProductName = stockData[2];
                }

                System.out.print("Enter new quantity (leave blank to keep unchanged): ");
                String newQuantityStr = IO.getScanner().nextLine();
                int newQuantity = newQuantityStr.isEmpty() ? Integer.parseInt(stockData[3]) : Integer.parseInt(newQuantityStr);

                // Validate that no other product has the same ID or name
                if (isDuplicate(finalFile, newProductID, newProductName, productID)) {
                    System.out.println(TextColors.ANSI_RED + "Error: Product with the same ID or name already exists!" + TextColors.ANSI_RESET);
                    return;  // Exit if a duplicate is found
                }

                // Update the line
                String updatedLine = newCategory + "|" + newProductID + "|" + newProductName + "|" + newQuantity;
                fileContent.add(updatedLine);
                updated = true;
            } else {
                // Keep other lines unchanged
                fileContent.add(currentLine);
            }
        }
    } catch (IOException e) {
        System.out.println(TextColors.ANSI_RED + "Error reading stock: " + e.getMessage() + TextColors.ANSI_RESET);
    }

    if (updated) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalFile))) {
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println(TextColors.ANSI_GREEN + "Stock updated successfully!" + TextColors.ANSI_RESET);
        } catch (IOException e) {
            System.out.println(TextColors.ANSI_RED + "Error writing updated stock: " + e.getMessage() + TextColors.ANSI_RESET);
        }
    } else {
        System.out.println(TextColors.ANSI_RED + "No matching stock found to update." + TextColors.ANSI_RESET);
    }
}


    // Helper method to check for duplicates in the stock file
    private static boolean isDuplicate(File file, String newProductID, String newProductName, String currentProductID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] stockData = currentLine.split("\\|");

                // Skip the current product being updated
                if (stockData[1].equals(currentProductID)) {
                    continue;
                }

                // Check if any product has the same ID or name as the new one
                if (stockData[1].equals(newProductID)) {
                    return true; // Duplicate product ID found
                }

                if (stockData[2].equalsIgnoreCase(newProductName)) {
                    return true; // Duplicate product name found
                }
            }
        } catch (IOException e) {
            System.out.println(TextColors.ANSI_RED + "Error checking for duplicates: " + e.getMessage() + TextColors.ANSI_RESET);
        }
        return false; // No duplicates found
    }

    public static void deleteStock() {
    File finalFile = new File(FILEPATH);

    System.out.print("Enter the category: ");
    String category = IO.getScanner().nextLine();

    System.out.print("Enter the product ID: ");
    String productID = IO.getScanner().nextLine();

    boolean stockFound = false;
    List<String> fileContent = new ArrayList<>();

    // Read the file and store lines except the one to delete
    try (
        BufferedReader reader = new BufferedReader(new FileReader(finalFile));
    ) {
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            String[] stockDetails = currentLine.split("\\|");
            if (stockDetails.length == 4) {
                String currentCategory = stockDetails[0].trim();
                String currentProductID = stockDetails[1].trim();

                // Check if the current line matches the product to delete
                if (currentCategory.equalsIgnoreCase(category) && currentProductID.equals(productID)) {
                    stockFound = true;
                    System.out.println(TextColors.ANSI_GREEN + "Deleting stock: " + currentLine + TextColors.ANSI_RESET);
                    continue; // Skip this line to delete it
                }
            }
            fileContent.add(currentLine); // Add remaining lines to fileContent
        }
    } catch (IOException e) {
        System.out.println(TextColors.ANSI_RED + "Error reading stock: " + e.getMessage() + TextColors.ANSI_RESET);
        return;
    }

    // If stock was found, rewrite the file with the remaining content
    if (stockFound) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(finalFile))) {
            for (String line : fileContent) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println(TextColors.ANSI_GREEN + "Stock deleted successfully!" + TextColors.ANSI_RESET);
        } catch (IOException e) {
            System.out.println(TextColors.ANSI_RED + "Error writing updated stock: " + e.getMessage() + TextColors.ANSI_RESET);
        }
    } else {
        System.out.println(TextColors.ANSI_RED + "No matching stock found." + TextColors.ANSI_RESET);
    }
  }
}
