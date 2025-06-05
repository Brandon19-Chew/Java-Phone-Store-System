
package Data.Getter;
import Classes.Supplier;
import Classes.Product;
import Utility.ArrayListLoader;
import java.util.ArrayList;


public class SupplierDataGetter {

    private static ArrayList<Supplier> suppList;
     
    public static int getSupplierIDIndex(String suppID){
        
        suppList = ArrayListLoader.loadSupplierList();

        
        String currentID;
        int indexCount = -1;
        
        for (int i = 0; i < suppList.size(); i++) {

            Supplier supplier = suppList.get(i);
            currentID = supplier.getSupplierID();

            // Check if the entered ID matches the supplier's ID
            if (suppID.equals(currentID)) {

                indexCount = i;  // Set the index when found
                break;  // Exit the loop once the ID is found

            }
        }
        
        return indexCount;
    }
        
    public static Supplier getAllSupplier(String suppID){
        
        int index = getSupplierIDIndex(suppID);

        Supplier supp = suppList.get(index);
        
        return supp;
    }
    
    //get supplier name through supplier ID
    public static String getSupplierName(String suppID){
                           
        int index = getSupplierIDIndex(suppID);
            
        String suppName = suppList.get(index).getSupplierName();
        
        return suppName;
    }
    
    //get supplier email through supplier ID
    public static String getSupplierEmail(String suppID){
                           
        int index = getSupplierIDIndex(suppID);
            
        String email = suppList.get(index).getEmail();
        
        return email;
    }
    
    //get supplier phone no through supplier ID
    public static String getSupplierPhoneNo(String suppID){
                           
        int index = getSupplierIDIndex(suppID);
            
        String phoneNo = suppList.get(index).getPhoneNo();
        
        return phoneNo;
    }
    
    //get supplier address through supplier ID
    public static String getSupplierAddress(String suppID){
                           
        int index = getSupplierIDIndex(suppID);
            
        String address = suppList.get(index).getAddress();
        
        return address;
    }
    
    
    //get product through supplier ID
    public static Product[] getProducts(String suppID){
                           
        int index = getSupplierIDIndex(suppID);
            
        Product[] product = suppList.get(index).getProductList();
        
        return product;
    }

    public static Product getProductByIndex(String suppID, int productIndex){
                           
        int index = getSupplierIDIndex(suppID);
            
        Product[] product = suppList.get(index).getProductList();
        
        return product[productIndex];
        
    }
    
    public static int getProductIndex(String suppID, String prodID){
        
        Product[] product = getProducts(suppID);
        String currentID;
        int indexCount = -1;
        
        for (int i = 0; i < product.length; i++) {

            currentID = product[i].getProductId();

            // Check if the entered ID matches the supplier's ID
            if (prodID.equals(currentID)) {

                indexCount = i;  // Set the index when found
                break;  // Exit the loop once the ID is found

            }
        }
        
        if (indexCount == -1) {
            System.out.println("Product ID doesn't exist, please enter again.");
        }
        
        return indexCount;
    }
    
    
}
