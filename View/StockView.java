package View;

import Utility.IO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Utility.SystemInput;


public class StockView {
    
     private static final String FILEPATH = "src/Resource_File/Stocks.txt";
    
    public static void viewAllStocks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            System.out.println("+==============================================================================================================+");
            System.out.println("|                                           All Category Stocks                                                |");
            System.out.println("+==============================================================================================================+");
            System.out.println("|           Category       |   Product ID  |                    Product Name                    |    Quantity  |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------+");

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] stockData = currentLine.split("\\|"); // Use pipe as delimiter

                // Ensure the line has exactly 4 elements
                if (stockData.length == 4) {
                    System.out.printf("| %-24s | %-12s  | %-40s           | %-10s   |\n",
                            stockData[0], stockData[1], stockData[2], stockData[3]);
                } else {
                    System.out.println("Malformed line found: " + currentLine);
                }
            }

            System.out.println("+==============================================================================================================+");

            // Pause until the user presses Enter
            SystemInput.pauseUntilInput();

        } catch (IOException e) {
            System.out.println("Error viewing stocks: " + e.getMessage());
        }
    }

  public static void viewStockByCategory() {
    try {
        System.out.print("Enter category: ");
        String category = IO.getScanner().nextLine().trim(); // Trim user input

        BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
        String currentLine;
        boolean found = false;

        System.out.println("+=======================================================================================================+");
        System.out.println("|          Category            |  Product ID |                   Product Name                | Quantity |");
        System.out.println("+------------------------------+-------------+-----------------------------------------------+----------+");

        while ((currentLine = reader.readLine()) != null) {
            String[] stockData = currentLine.split("\\|"); // Use pipe as delimiter
            if (stockData[0].trim().equalsIgnoreCase(category)) { // Trim and compare ignoring case
                System.out.printf("| %-28s | %-12s| %-40s      | %-8s |\n",
                        stockData[0], stockData[1], stockData[2], stockData[3]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stock found for the given category.");
        }

        System.out.println("+=======================================================================================================+");

        // Pause until the user presses Enter
        SystemInput.pauseUntilInput();

    } catch (IOException e) {
        System.out.println("Error viewing stock: " + e.getMessage());
    }
}


  public static void viewStockByProductIDAndCategory() {
    try {
        System.out.print("Enter category: ");
        String category = IO.getScanner().nextLine().trim(); // Trim user input

        System.out.print("Enter product ID: ");
        String productID = IO.getScanner().nextLine().trim(); // Trim user input

        BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
        String currentLine;
        boolean found = false;

        System.out.println("+=======================================================================================================+");
        System.out.println("|          Category            |  Product ID |                   Product Name                | Quantity |");
        System.out.println("+------------------------------+-------------+-----------------------------------------------+----------+");

        while ((currentLine = reader.readLine()) != null) {
            String[] stockData = currentLine.split("\\|"); // Use pipe as delimiter
            if (stockData[0].trim().equalsIgnoreCase(category) && stockData[1].trim().equals(productID)) { // Trim both category and productID
                System.out.printf("| %-28s | %-12s| %-40s      | %-8s |\n",
                        stockData[0], stockData[1], stockData[2], stockData[3]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stock found for the given category and product ID.");
        }

        System.out.println("+=======================================================================================================+");

        // Pause until the user presses Enter
        SystemInput.pauseUntilInput();

    } catch (IOException e) {
        System.out.println("Error viewing stock: " + e.getMessage());
    }
}

}
