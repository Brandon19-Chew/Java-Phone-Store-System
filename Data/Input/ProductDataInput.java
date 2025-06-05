
package Data.Input;

import Data.Validation.ProductDataValidation;
import Utility.IO;

public class ProductDataInput {
    
    public static String checkProductIDInput(){
        
        String prodID;
        do{
            System.out.print("Please enter the Product ID : ");
            prodID = IO.getScanner().nextLine();

        }while(!ProductDataValidation.checkProductIDExistence(prodID));

        return prodID;
    }
    
    public static String checkProductNameInput(){
        
        String prodName;
        do{
            System.out.print("Please enter the product Name : ");
            prodName = IO.getScanner().nextLine();

        }while(!ProductDataValidation.checkProductNameFormat(prodName));

        return prodName;
        
    }
    
        public static double checkProductPriceInput(){
        
        double price;
        
            do{
                System.out.print("Please enter the price : RM");
                price = IO.getScanner().nextDouble();
                
                //consume enter key
                IO.getScanner().nextLine();
                            
            }while(!ProductDataValidation.checkProductPriceFormat(price));
            
        return price;
        
    }
        
        
}
