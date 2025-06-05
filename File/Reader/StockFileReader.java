
package File.Reader;

import Classes.Stock;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class StockFileReader {
       
    // Read Stock data from stocks.txt
    public static ArrayList<Stock> readStockFile(String filePath) {
        ArrayList<Stock> stockList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String category = parts[0];
                    String productID = parts[1];
                    String productName = parts[2];
                    int quantity = Integer.parseInt(parts[3]);
                    Stock stock = new Stock(category, productID, productName, quantity);
                    stockList.add(stock);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred when reading stock file.");
        }
        return stockList;
    }
}
