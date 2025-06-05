
package Utility;

import Classes.Product;
import Classes.PurchaseOrder;
import Classes.Supplier;
import java.util.ArrayList;


public class IDGenerator {
    
    public static String GenerateSupplierID(ArrayList<Supplier> supplierList){
        
        String newSuppID = new String();
        
        if(!supplierList.isEmpty()){
            
            //find the latest Supplier ID
            String strSupp = supplierList.get(supplierList.size()-1).getSupplierID();   

            //convert the S001 become 001
            String suppNumber = strSupp.substring(1);

            //convert string to int
            int currentSuppID = Integer.parseInt(suppNumber);
            //add 1 to new PO number
            newSuppID = String.format("S%03d", currentSuppID + 1);
            
        }else
            newSuppID = "P0001";
            
        
        
        return newSuppID;
        
    }
    
    public static String GenerateProductID(ArrayList<Product> productList){
       
        String newProdID = new String();
        
        if(!productList.isEmpty()){
            
            //find the latest Product ID
            String strProd = productList.get(productList.size()-1).getProductId();   

            //convert the PD0001 become 0001
            String prodID = strProd.substring(2);

            //convert string to int
            int currentProdID = Integer.parseInt(prodID);

            //add 1 to new PO number
            newProdID = String.format("PD%04d", currentProdID + 1);
            
        }else
            newProdID = "PD0001";
        
        return newProdID;
        
    }
    
    public static String GeneratePONumber(ArrayList<PurchaseOrder> poList){
        
        String newPONo = new String();
        
        if(!poList.isEmpty()){
            
            String strPO = poList.get(poList.size()-1).getNumber();

            String poNum = strPO.substring(1);

            int currentPONum = Integer.parseInt(poNum);

            newPONo = String.format("P%04d", currentPONum + 1);
            
        }else
            newPONo = "P0001";
          
        return newPONo;
    }
    
    
}
