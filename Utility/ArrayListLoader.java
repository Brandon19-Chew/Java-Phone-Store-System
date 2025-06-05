
package Utility;

import File.Reader.*;
import Classes.*;
import File.Reader.PaymentFileReader;
import static Utility.FileLocation.*;
import java.util.ArrayList;

public class ArrayListLoader extends FileLocation {


    public static ArrayList<Product> loadProductList(){
        
        try{
            productList = new ArrayList<>(ProductFileReader.readProductFile(PRODUCT_FILE));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return productList;
    }
    
    public static ArrayList<Supplier> loadSupplierList(){
        
        try{
            supplierList = new ArrayList<>(SupplierFileReader.readSupplierFile(SUPPLIER_FILE));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return supplierList;
        
    }
    
    
    public static ArrayList<PurchaseOrder> loadPOList(){
        
        try{
            poList = POFileReader.readPOFile(PO_FILE);
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return poList;
        
    }


    
    public static ArrayList<DeliveryOrder> loadDOList(){
        
        try{
            poList = new ArrayList<>(loadPOList());
            
            doList = DeliveryFileReader.readDeliveryFile(DO_FILE);
            
            for(int i = 0; i< doList.size(); i++){
                
                for (DeliveryOrder deliveryOrder : doList) {
                    for(PurchaseOrder po:poList){

                        if(doList.get(i).getNumber().equals(po.getNumber())){
                            doList.get(i).setPO(po);
                    }
                }
                
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return doList;
        
        
        
        
    }
        
    public static ArrayList<Payment> loadPayList(){
        
        try{
            
            payList = PaymentFileReader.readInvoiceFile(PAYMENT_FILE);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return payList;
        
        }

    
}