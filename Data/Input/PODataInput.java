
package Data.Input;

import Data.Validation.PODataValidation;
import Utility.IO;
import Utility.SystemInput;


public class PODataInput {
    
    public static String checkPONumberInput(){
        
        String poNum;
        do{

            System.out.print("Please enter the PO number : ");
             poNum = IO.getScanner().nextLine();

        }while(!PODataValidation.checkPoNoExistence(poNum));

        return poNum;
    }
    
    public static String checkPONumberStatusInput(){
        
        String poNum;
        do{

            System.out.print("Please enter the PO number : ");
             poNum = IO.getScanner().nextLine();
             

        }while(!PODataValidation.checkProcPoNoExistence(poNum));

        return poNum;
        
    }
        
    
    public static int checkStockQuantity(){
        
        int quantity;
        do{
            System.out.print("Please enter quantity : ");
            quantity = SystemInput.inputForInt();

            if(quantity <=0)
                System.out.println("Quantity cannot less then or equal to 0, please try again. ");

        }while(quantity <=0);
        
        return quantity;
    }
    
    
}
