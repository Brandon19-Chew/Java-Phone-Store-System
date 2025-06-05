
package Utility;

import Classes.*;
import java.util.ArrayList;


public class FileLocation {
    
    //admin text file location
    protected static final String ADMIN_FILE = "src/Resource_File/Admin.txt";
    
    //admin log text file location
    protected static final String ADMIN_LOG_FILE = "src/Resource_File/AdminHistory.txt";
    
    //prouct text file location
    protected static final String PRODUCT_FILE = "src/Resource_File/Product.txt";
    protected static ArrayList<Product> productList = new ArrayList<>();

    //stock text file location
    protected static final String STOCK_FILE = "src/Resource_File/Stock.txt";
    
    //supplier text file location & supplier ArrayList
    protected static final String SUPPLIER_FILE = "src/Resource_File/Supplier.txt";
    protected static ArrayList<Supplier> supplierList = new ArrayList<>();
    
    //purchase order text file location & purchase order ArrayList
    protected static final String PO_FILE = "src/Resource_File/PurchaseOrder.txt";
    protected static ArrayList<PurchaseOrder> poList = new ArrayList<>();

    protected static final String DO_FILE = "src/Resource_File/Delivery.txt";
    protected static ArrayList<DeliveryOrder> doList = new ArrayList<>();
    
    protected static final String PAYMENT_FILE = "src/Resource_File/Invoice.txt";
    protected static ArrayList<Payment> payList = new ArrayList<>();
}
