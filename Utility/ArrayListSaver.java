
package Utility;

import Classes.Payment;
import File.Writer.POFileWriter;
import File.Writer.ProductFileWriter;
import File.Writer.SupplierFileWriter;
import Classes.PurchaseOrder;
import Classes.Supplier;
import Classes.Product;
import File.Writer.PaymentFileWriter;
import java.util.ArrayList;

public class ArrayListSaver extends FileLocation {

    
    
    public static void saveProductList(ArrayList<Product> prodList){
        
        ProductFileWriter.writeProductFile(PRODUCT_FILE, prodList);
        
    }
    
    public static void saveSupplierList(ArrayList<Supplier> suppList){
        
        SupplierFileWriter.writeSupplierFile(SUPPLIER_FILE, suppList);
        
    }
    
    public static void savePOList(ArrayList<PurchaseOrder> poList){
        
        POFileWriter.writePOFile(PO_FILE, poList);
    }
    
        
    public static void savePaymentList(ArrayList<Payment> payList){
        
        PaymentFileWriter.writePayFile(PAYMENT_FILE, payList);
    }
    
}
