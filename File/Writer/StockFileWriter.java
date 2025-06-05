
package File.Writer;

import Classes.Stock;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author roney
 */
public class StockFileWriter {
    // Write Stock data to stocks.txt
  public static void writeStockFile(String filePath, ArrayList<Stock> stockList) {
    // Sort the stock list by product ID in ascending order
    stockList.sort(Comparator.comparing(Stock::getProductID));
    
    try (FileWriter writeFile = new FileWriter(filePath)) {
        for (Stock stock : stockList) {
            String category = stock.getCategory();
            String productID = stock.getProductID();
            String productName = stock.getProductName();
            int quantity = stock.getQuantity();

            String format = category + "|" + productID + "|" + productName + "|" + quantity + "\n";
            writeFile.write(format);
        }
    } catch (IOException e) {
        System.out.println("An error occurred when writing stock file.");
    }
}

}
