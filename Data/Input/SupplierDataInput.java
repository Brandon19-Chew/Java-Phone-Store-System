
package Data.Input;

import Data.Validation.SupplierDataValidation;
import Utility.IO;

public class SupplierDataInput {
    
    public static String checkSupplierIDInput(){
        
        String suppID;
        do{
            System.out.print("Please Enter the Supplier ID : ");
            suppID = IO.getScanner().nextLine();
            
        }while(!SupplierDataValidation.checkSupplierIDExistence(suppID));
        
        return suppID;
        
    }
    
    public static String checkSupplierNameInput(){
        
        String suppName;
        do{
            System.out.print("Please enter the Supplier Name : ");
            suppName = IO.getScanner().nextLine();
            
            
        }while(!SupplierDataValidation.checkSupplierNameFormat(suppName));
    
        return suppName;
        
    }
    
    public static String checkSupplierEmailInput(){
        
        String email;
        do{
            System.out.print("Please enter email address : ");
            email = IO.getScanner().nextLine();            
       
        }while(!SupplierDataValidation.checkSupplierEmailFormat(email));
        
        
        return email;
        
    }
        
    public static String checkSupplierPhNoInput(){
        
        String phoneNo;
        
        do{
            System.out.print("Please enter the phone number : ");
            phoneNo = IO.getScanner().nextLine();
            
        }while(!SupplierDataValidation.checkSupplierPhNoFormat(phoneNo));
        
        return phoneNo;
        
    }
            
    public static String checkSupplierAddressInput(){
        
        String address;
        do{
            System.out.print("Please enter Supplier address : ");
            address = IO.getScanner().nextLine();

        }while(!SupplierDataValidation.checkSupplierAddressFormat(address));
        
        return address;
        
    }
    
    public static String checkProductIDInSupplierInput(String suppID){
        
        String productID;
        
        do{
            System.out.print("Please enter product ID : ");
            productID = IO.getScanner().nextLine();
 
        }while(!SupplierDataValidation.checkProductIDInSupplier(suppID, productID));
        
        return productID;
    }
   
}
