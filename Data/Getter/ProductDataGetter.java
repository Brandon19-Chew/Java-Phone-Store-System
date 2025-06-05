
package Data.Getter;


import Classes.Product;
import Utility.ArrayListLoader;
import java.util.ArrayList;

public class ProductDataGetter {
    
    private static ArrayList<Product> prodList;

    
    public static int getProductIndex(String prodID){
                
        prodList = ArrayListLoader.loadProductList();
        
        String currentID;
        int indexCount = -1;
        
        for (int i = 0; i < prodList.size(); i++) {

            Product prod = prodList.get(i);
            
            currentID = prod.getProductId();

            // Check if the entered ID matches the supplier's ID
            if (prodID.equals(currentID)) {

                indexCount = i;  // Set the index when found
                break;  // Exit the loop once the ID is found

            }
        }
   
        return indexCount;
    }
    
    public static String getProductName(String prodID){
                           
        int index = getProductIndex(prodID);
            
        String prodName = prodList.get(index).getProductName();
        
        return prodName;
        
    }
    
        public static double getProductPrice(String prodID){
                           
        int index = getProductIndex(prodID);
            
        double price = prodList.get(index).getPrice();
        
        return price;
        
    }


}
