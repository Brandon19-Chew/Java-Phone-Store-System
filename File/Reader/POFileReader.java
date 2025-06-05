
package File.Reader;

import Classes.Product;
import Classes.PurchaseOrder;
import Classes.Supplier;
import Utility.DocumentStatus;
import Utility.ArrayListLoader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class POFileReader {
    
    //read for PurchaseOrder.txt
    public static ArrayList<PurchaseOrder> readPOFile(String filePath){
       
        ArrayList<PurchaseOrder> poList = new ArrayList<>();       
        ArrayList<Supplier> suppList = ArrayListLoader.loadSupplierList();
        ArrayList<Product> productList = ArrayListLoader.loadProductList();
        
        String poNumber;
        String poDate;
        String supplierID;
        boolean status;
        double totalPrices = 0;       
        
        try(FileReader readFile = new FileReader(filePath)){
                
            Scanner fileRead = new Scanner(readFile);
            
            //when scanner has scanned next line
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                //split the text file to supplier class                
                //tempolary save to local array
                String[] splitCount = line.split("\\|");
                                

                // Create a new Supplier object for each line

                //split the array to correnspond variable
                poNumber = splitCount[0];
                poDate = splitCount[1];
                supplierID = splitCount[2];
                status = DocumentStatus.checkStatus(splitCount[6]);

                Supplier supplier = new Supplier();
                
                for(Supplier supp:suppList){
                    if(supp.getSupplierID().equals(supplierID)){
                        supplier = supp;
                    }
                }
                // Split product IDs and quantity by comma
                String[] productIDs = splitCount[3].split(",");
                //convert to String first
                String[] quantitiesString = splitCount[4].split(",");
                
                //storage of quantity in integer
                int[] quantities = new int[quantitiesString.length];
                
                int productCount = productIDs.length;

                PurchaseOrder po = new PurchaseOrder(poNumber, poDate, status);

                int count = 0;

                for (int i = 0; i < productList.size() && count < productCount; i++) {
                    String currentID = productIDs[count];

                    // Check if the product ID matches
                    if (productList.get(i) != null && productList.get(i).getProductId().equals(currentID)) {
                        
                        quantities[count] = Integer.parseInt(quantitiesString[count].trim());
                        
                        po.addProduct(productList.get(i), quantities[count]);
                        totalPrices += po.getTotalPricesByProduct(productList.get(i));
                        count++;
                    }
                }
                
                po.setSupplier(supplier);
                po.setTotalPrices(totalPrices);
                
                //save to Supplier class
                poList.add(po);

            }                

            
            fileRead.close();
        
        } catch (IOException e) {
            System.out.println("An error occurred when reading supplier file.");
            e.printStackTrace();
        }
               
        return poList;
   }
}
