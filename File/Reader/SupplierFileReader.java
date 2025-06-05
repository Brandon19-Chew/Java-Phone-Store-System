
package File.Reader;

import Classes.Supplier;
import Classes.Product;
import Utility.ArrayListLoader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

//read supplier related text file
public  class SupplierFileReader {
    
    //read for Supplier.txt
    public static ArrayList<Supplier> readSupplierFile(String filePath){
        //open ArayList
        ArrayList<Supplier> supplierList = new ArrayList<>();
        ArrayList<Product> productList = ArrayListLoader.loadProductList();
        String suppID; 
        String name;
        String phoneNo;
        String address;
        String email;
        int count = 0;

        
        
        //open text file
        try(FileReader readFile = new FileReader(filePath)){
            
            Scanner fileRead = new Scanner(readFile);
            
            //when scanner has scanned next line
            //when scanner has scanned next line
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();

                // Temporarily save to local array
                String[] splitCount = line.split("\\|");

                if (splitCount.length == 6) {
                    // Split the array into corresponding variables
                    suppID = splitCount[0];
                    name = splitCount[1];  
                    email = splitCount[2];
                    phoneNo = splitCount[3];
                    address = splitCount[4];

                    // Split product IDs by comma
                    String[] productIDs = splitCount[5].split(",");
                    
                    int productCount = productIDs.length;
                    
                    Product[] products = new Product[productCount];
                    
                    Supplier supplier = new Supplier(suppID, name, email, phoneNo, address, products);

                    // Count variable to keep track of productID index
                    count = 0;

                    // Add products to the supplier
                    for (int i = 0; i < productList.size() && count < productCount; i++) {
                        String currentID = productIDs[count];

                        // Check if the product ID matches
                        if (productList.get(i) != null && productList.get(i).getProductId().equals(currentID)) {
                            // Add the product to the supplier
                            Product product = productList.get(i);
                            supplier.addProduct(product, count);

                            // Increment count to move to the next product ID
                            count++;
                        }
                    }

                    // Add the supplier to the supplierList
                    supplierList.add(supplier);
                }
            }
            fileRead.close();
        
        } catch (IOException e) {
            System.out.println("An error occurred when reading supplier file.");
            e.printStackTrace();
        }

        return supplierList;
    }
    

    
}