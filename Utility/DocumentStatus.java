
package Utility;


public class DocumentStatus {

    public static boolean checkStatus(String status){
        
        if(status.equals("Completed"))
            return true;
        
        return false;   
    }
    
    public static String poStatus(boolean status){
        
        String condition;
        
        if(!status)
            condition = "Processing";
        else
            condition = "Completed";
        
        return condition;
       
    }
        
    
}
