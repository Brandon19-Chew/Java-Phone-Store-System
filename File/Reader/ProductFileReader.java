package File.Reader;

import Classes.Product;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProductFileReader {
        //read for Supplier.txt
    public static ArrayList<Product> readProductFile(String filePath){
        //open ArayList
        ArrayList<Product> productList = new ArrayList<>();
        String prodID;
        String prodName;
        double price;
        
        //open text file
        try(FileReader readFile = new FileReader(filePath)){
            
            Scanner fileRead = new Scanner(readFile);
            
            //when scanner has scanned next line
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();

                //tempolary save to local array
                String[] splitCount = line.split("\\|");
                
                if(splitCount.length == 3){
                    
                    //split the array to correnspond variable
                    prodID = splitCount[0];
                    prodName = splitCount[1];
                    price = Double.parseDouble(splitCount[2]);

                                      
                    //save to Supplier class
                    productList.add(new Product(prodID, prodName, price));
                                   
                }                
                               
            }
            fileRead.close();
        
        } catch (IOException e) {
            System.out.println("An error occurred when reading product file.");
            e.printStackTrace();
        }

        return productList;
    }
    
}

