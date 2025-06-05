
package Data.Validation;

import Classes.Product;
import Utility.ArrayListLoader;
import java.util.ArrayList;


public class ProductDataValidation {
        private static ArrayList <Product> prodList;
    
    public static boolean checkProductIDExistence(String prodNo){
        
        prodList = ArrayListLoader.loadProductList();
        
        for(Product prod:prodList){
            
            String currentProdID = prod.getProductId();
            
            if(prodNo.equals(currentProdID)){
                return true;
            }
        }
        
        System.out.println("The product ID doesn't exist, please try again.");
        return false;
        
    }
    
    public static boolean checkProductNameFormat(String name){
        
        if(name.length() > 20){
            System.out.println("The product name exceeds the limit, please try again.");
            return false;
        }
        
        if(name.length() <=0){
            System.out.println("The product name cannot be empty. please enter again.");
            return false;
        }
        
        return true;
    }
    
    public static boolean checkProductPriceFormat(double price){
        
        if(price > 10000d){
            System.out.println("The unit price exceeds the limit, please try again.");
            return false;
        }
        
        if(price <= 0){
            System.out.println("The unit price cannot below 0, please enter again.");
            return false;
        }
        
        return true;
    }
    
    
    
}
