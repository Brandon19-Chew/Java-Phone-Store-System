
package File.Writer;

import Classes.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductFileWriter {
        //write into PurchaseOrder.txt
    public static void writeProductFile(String filePath, ArrayList<Product> poList){

        try(FileWriter writeFile = new FileWriter(filePath)){
            
            for(Product prod : poList)  {
                           
                String prodID = prod.getProductId();
                String prodName = prod.getProductName();
                double price = prod.getPrice();
                
                String format = prodID + "|" + prodName + "|" + price + "\n";
                
               writeFile.write(format);
                 
             } 
                            
            writeFile.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred when writing product file.");
            e.printStackTrace();
        }
        
        
        
    }
}
