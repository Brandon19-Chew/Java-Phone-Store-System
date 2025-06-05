
package File.Writer;

import Classes.Supplier;
import Classes.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author chin wee jian
 */


    
public class SupplierFileWriter {
    
    //write into Supplier.txt
    public static void writeSupplierFile(String filePath, ArrayList<Supplier> supplierList){
        
        
        try(FileWriter writeFile = new FileWriter(filePath)){
            
            for(Supplier supplier : supplierList)  {
                           
                String suppID= supplier.getSupplierID();                    
                String name = supplier.getSupplierName();
                String email = supplier.getEmail();
                String phoneNo = supplier.getPhoneNo();
                String address = supplier.getAddress();
                
                // Iterate over the products
                Product[] products = supplier.getProductList();
                StringBuilder productIDs = new StringBuilder();

                 for (int i = 0; i < products.length; i++) {
                     if (products[i] != null) {
                         productIDs.append(products[i].getProductId());
                         if (i != products.length - 1) {
                             productIDs.append(",");  // Add a comma between product IDs
                         }
                     }
                 }
                 
                 productIDs.substring(0, productIDs.length()-1);

               String format = String.format("%s|%s|%s|%s|%s|%s%n", suppID, name, email, phoneNo, address,productIDs);
                
               writeFile.write(format);
                 
             }      
                   
            writeFile.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred when writing supplier file.");
            e.printStackTrace();        
        }
        
    }
    

}
