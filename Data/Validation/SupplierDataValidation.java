
package Data.Validation;

import Classes.Product;
import Classes.Supplier;
import Utility.ArrayListLoader;
import java.util.ArrayList;
import static Data.Getter.SupplierDataGetter.getProducts;

public class SupplierDataValidation {

    //email format
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    //phone number format
    private static final String PHONE_PATTERN = "^(\\+?60|0)?1\\d{1}-\\d{7}$";
        
      
    public static boolean checkSupplierIDExistence(String suppID){
        ArrayList<Supplier> suppList = ArrayListLoader.loadSupplierList();
        
        for(Supplier supp:suppList){
            
            String currentSuppID = supp.getSupplierID();
            
            if(suppID.equals(currentSuppID)){
                return true;
            }
            
        }
        
        System.out.println("The supplier ID doesn't exist, please try again.");
        return false;

    }
    
    public static boolean checkSupplierNameFormat(String suppName){
            //Check Supplier name characters count
            if(suppName.length() >20){
                System.out.println("The Name is exceeding the limit, please enter again.");
                return false;
            }            
            
            if(suppName.length() <=0){
                System.out.println("The Name cannot be empty, please enter again.");
                return false;
            }
            
            return true;            
    }
    
    public static boolean checkSupplierEmailFormat(String email){
        
        if(!email.matches(EMAIL_PATTERN))
            System.out.println("The email format is incorrect, please enter again.");
        
        if(email.length() <= 0){
            System.out.println("The email cannot be empty, please enter again.");
            return false;
        }

        return email.matches(EMAIL_PATTERN);
    }
    
    public static boolean checkSupplierPhNoFormat(String phoneNo){
                        //Check phone number format
        if(!phoneNo.matches(PHONE_PATTERN))
            System.out.println("The phone number format is incorrect, please enter again.");

        return phoneNo.matches(PHONE_PATTERN);
    }
    
    public static boolean checkSupplierAddressFormat(String address){
        
        //Check address character limits
        if(address.length() > 64){
            System.out.println("The address is exceeding limit, please again again");
            return false;  
        }
        
        if(address.length() <= 0){
            System.out.println("The address cannot be empty, please enter again.");
            return false;
        }
         
        return true;
        
    }
    
    public static boolean checkProductIDInSupplier(String suppID, String prodID){
        
        Product[] product = getProducts(suppID);
        String currentID;
        
        for (int i = 0; i < product.length; i++) {

            currentID = product[i].getProductId();

            // Check if the entered ID matches the supplier's ID
            if (prodID.equals(currentID)) {
                return true;
            }
        }
        
        
        System.out.println("Product ID doesn't exist, please enter again.");
        return false;
    }

}
