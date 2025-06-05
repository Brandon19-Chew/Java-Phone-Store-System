
package File.Writer;

import Classes.Product;
import Classes.PurchaseOrder;
import Utility.DocumentStatus;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class POFileWriter {

    //write into PurchaseOrder.txt
    public static void writePOFile(String filePath, ArrayList<PurchaseOrder> poList){

        try(FileWriter writeFile = new FileWriter(filePath)){
            
            for(PurchaseOrder po : poList)  {
                           
                String poNumber = po.getNumber();
                String poDate = po.getDate();
                String supplierID = po.getSupplier().getSupplierID();
                String status = DocumentStatus.poStatus(po.getStatus());
                
                HashMap<Product, Integer> stocks = po.getStocks();
                
                StringBuilder productID = new StringBuilder();
                StringBuilder quantity = new StringBuilder();
                
                double totalPrice = 0;
                
                // Get the product keys and sort them by ProductId
                List<Product> productList = new ArrayList<>(stocks.keySet());
                productList.sort(Comparator.comparing(Product::getProductId));

                // Now iterate over the sorted list
                for (Product prod : productList) {
                    productID.append(prod.getProductId());
                    quantity.append(stocks.get(prod));

                    productID.append(",");
                    quantity.append(",");

                    totalPrice += po.getTotalPricesByProduct(prod);
                }
                
                
                //remove last comma(,)
                String productIDs = productID.substring(0, productID.length() -1);
                String quantities = quantity.substring(0, quantity.length() -1);
                

               String format = poNumber + "|" + poDate + "|" + supplierID + "|" + productIDs + "|" + quantities + "|" + totalPrice + "|" + status + "\n";
                
               writeFile.write(format);
                 
             } 
                            
            writeFile.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred when writing Purchase Order file.");
            e.printStackTrace();
        }
        
        
        
    }
}
