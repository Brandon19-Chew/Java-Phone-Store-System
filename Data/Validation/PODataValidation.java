
package Data.Validation;

import Classes.PurchaseOrder;
import Data.Getter.PODataGetter;
import Utility.ArrayListLoader;
import java.util.ArrayList;



public class PODataValidation {

    private static ArrayList <PurchaseOrder> poList;
    
    public static boolean checkPoNoExistence(String poNo){
        
        poList = ArrayListLoader.loadPOList();
        
        for(PurchaseOrder po:poList){
            
            String currentPO = po.getNumber();
            
            if(poNo.equals(currentPO)){
                return true;
            }
            
        }
        
        System.out.println("The PO number doesn't exist, please try again.");
        return false;
        
    }
    
    public static boolean checkProcPoNoExistence(String poNo){

        poList = PODataGetter.getProcessingPOList();
        
        for(PurchaseOrder po:poList){

            if(poNo.equals(po.getNumber())){
                return true;
            }
        }
        
        System.out.println("The PO number doesn't exist, please try again.");
        return false;
    }
    
}
