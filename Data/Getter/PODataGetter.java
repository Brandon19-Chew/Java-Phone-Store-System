
package Data.Getter;

import Classes.Product;
import Classes.PurchaseOrder;
import Classes.Supplier;
import Utility.ArrayListLoader;
import java.util.ArrayList;
import java.util.HashMap;


public class PODataGetter{

    public static ArrayList<PurchaseOrder> poList;
    
   

    public static int getPOIndex(String poNo){
        
        poList = ArrayListLoader.loadPOList();
        
        String currentID;
        int indexCount = -1;
        
        for (int i = 0; i < poList.size(); i++) {

            PurchaseOrder po = poList.get(i);
            currentID = po.getNumber();

            // Check if the entered ID matches the supplier's ID
            if (poNo.equals(currentID)) {

                indexCount = i;  // Set the index when found
                break;  // Exit the loop once the ID is found

            }
        }
  
        return indexCount;
    }
    
     //get supplier name through supplier ID
    public static String getPODate(String poNo){
                           
        int index = getPOIndex(poNo);
            
        String poDate = poList.get(index).getDate();
        
        return poDate;
    }

    public static Supplier getSupplierByPo(String poNo){
                           
        int index = getPOIndex(poNo);
            
        Supplier supp = poList.get(index).getSupplier();
        
        return supp;
        
    }
    
    public static HashMap<Product, Integer> getStocksByPo(String poNo){
                           
        int index = getPOIndex(poNo);
            
        HashMap<Product, Integer> stocks = poList.get(index).getStocks();
        
        return stocks;
        
    }
    
    public static Product[] getAllProducts(String poNo) {
        
        int index = getPOIndex(poNo);  // Find the index of the purchase order

        HashMap<Product, Integer> stocks = poList.get(index).getStocks();

        // Initialize the products array with the size of the stocks HashMap
        Product[] products = new Product[stocks.size()];

        int i = 0;
        for (Product product : stocks.keySet()) {
            // Initialize a new Product object at each index
            products[i] = new Product();

            // Copy the product details into the new product object
            products[i].setProductId(product.getProductId());
            products[i].setProductName(product.getProductName());
            products[i].setPrice(product.getPrice());

            i++;  // Move to the next index
        }

        return products;  // Return the array of products
    }

    
    public static int[] getProductQuantities(String poNo){
                
        int index = getPOIndex(poNo);
        
        HashMap<Product, Integer> stocks = poList.get(index).getStocks();
        
        int[] quantities = new int[stocks.size()];
        
        int i = 0;
        for (Product product : stocks.keySet()) {
        
            quantities[i] = stocks.get(product);

            i++;
        }

        return quantities;
    }
    
    public static double getTotalPrices(String poNo){
                
        double totalAmount = 0d;
        int index = getPOIndex(poNo);

        HashMap<Product, Integer> stocks = poList.get(index).getStocks();
        
        for(Product prod : stocks.keySet()){
            
            totalAmount += stocks.get(prod) * prod.getPrice();

        }
        
        return totalAmount;
    }
    
    public static double getTotalAmountByMonth(ArrayList<PurchaseOrder> poListInMonth){

        double totalAmount = 0;

        for(PurchaseOrder po:poListInMonth){

            totalAmount += po.getTotalPrices();

        }

        return totalAmount;
    }
        
    public static double getAverageAmountByMonth(ArrayList<PurchaseOrder> poListInMonth){
                
        double totalAmount = 0;
        int count = 0;
        
        for(PurchaseOrder po:poListInMonth){

            totalAmount += po.getTotalPrices();
            count++;
        }

        return totalAmount / count ;
    }
    
    
    
    public static ArrayList<PurchaseOrder> getPOListByMonth(int year, int month){
        
        poList = ArrayListLoader.loadPOList();

        ArrayList<PurchaseOrder> poByMonth = new ArrayList<>();
        
        String[] poMonth;
        int checkMonth;
        int checkYear;
        
        for(int i = 0; i < poList.size(); i++){
            
            poMonth = poList.get(i).getDate().split("\\/");
            checkMonth = Integer.parseInt(poMonth[1]);
            checkYear = Integer.parseInt(poMonth[2]);
            
            if(checkMonth == month && checkYear == year){
                poByMonth.add(poList.get(i));
            }
                                    
        }
     
        if(poByMonth.isEmpty())
            System.out.println("No record in this month.");
        
        
        return poByMonth;
        
    }  
    
    public static ArrayList<PurchaseOrder> getProcessingPOList(){
        
        poList = ArrayListLoader.loadPOList();

        ArrayList<PurchaseOrder> processingPO = new ArrayList<>();
        
        for(PurchaseOrder po:poList){
            
            if(!po.getStatus()){
                
                processingPO.add(po);
                
            }
            
        }
        
        return processingPO;
        
    }
        
}
