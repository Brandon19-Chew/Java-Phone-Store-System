
package View;
import Classes.Product;
import Utility.StoreInformation;
import Utility.SystemInput;
import Utility.AddressFormat;
import Utility.DateGenerator;
import Data.Getter.PODataGetter;
import Classes.PurchaseOrder;
import Data.Getter.SupplierDataGetter;
import Utility.DocumentStatus;
import Utility.ArrayListLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PurchaseOrderView {

    
    public static void generatePo(String poNum){
        
        //Store Information
        String storeName = StoreInformation.getStoreName();
        String storePhoneNo = StoreInformation.getStorePhoneNo();
        String storeEmail = StoreInformation.getStoreEmail();
        String storeAddress = StoreInformation.getStoreAddress();
        String[] storeAddressArray = AddressFormat.splitAddressLine(storeAddress);     
        
        
        //PO Information
        String poDate = PODataGetter.getPODate(poNum);
        String supplierID = PODataGetter.getSupplierByPo(poNum).getSupplierID();
        Product[] allProduct = PODataGetter.getAllProducts(poNum);
        int[] stockQuantities = PODataGetter.getProductQuantities(poNum);
        double priceTotal = PODataGetter.getTotalPrices(poNum);
        
        //Supplier Information
        String suppName = SupplierDataGetter.getSupplierName(supplierID);
        String suppEmail = SupplierDataGetter.getSupplierEmail(supplierID);
        String suppPhoneNo = SupplierDataGetter.getSupplierPhoneNo(supplierID);
        String suppAddress = SupplierDataGetter.getSupplierAddress(supplierID);
        String[] suppAddressArray = AddressFormat.splitAddressLine(suppAddress);
        
        //Stock Information
        String[] productID = new String[allProduct.length];
        String[] productName = new String[allProduct.length];
        double[] productPrice = new double[allProduct.length];
        
        
        System.out.printf(" ______________________________________________________________________ \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|                       ------------------------                       | \n");
        System.out.printf("|                       |    Purchase Order    |                       | \n");
        System.out.printf("|                       ------------------------                       | \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|   %-30s          PO Number: %-5s           | \n", storeName, poNum);
        System.out.printf("|                                                                      | \n");
        System.out.printf("|   %-32s        PO Date  : %10s      | \n", storeAddressArray[0], poDate);
        System.out.printf("|   %-32s                                   | \n", storeAddressArray[1]);
        System.out.printf("|   %-32s                                   | \n", storeAddressArray[2]);
        System.out.printf("|                                                                      | \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|    Vendor:                         Ship To:                          | \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|    %-18s              %-18s                | \n",suppName, storeName);
        System.out.printf("|    %-31s %-32s  | \n", suppAddressArray[0], storeAddressArray[0]);
        System.out.printf("|    %-31s %-32s  | \n",suppAddressArray[1], storeAddressArray[1]);
        System.out.printf("|    %-31s %-32s  | \n", suppAddressArray[2], storeAddressArray[2]);
        System.out.printf("|    %-11s                     %-11s                       | \n", suppPhoneNo, storePhoneNo);
        System.out.printf("|    %-25s       %-25s         | \n", suppEmail, storeEmail);
        System.out.printf("|                                                                      | \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|     Delivery Date:%-10s                                         | \n", DateGenerator.getDeliveryDate(10));
        System.out.printf("|   +--------------------------------------------------------------+   | \n");
        System.out.printf("|   | Product ID |    Name                  | Quantity | Unit (RM) |   | \n");
        System.out.printf("|   |------------|--------------------------|----------|-----------|   | \n");
        
        int minRow = 5;
        for(int i = 0; i < allProduct.length || i < minRow; i++){
            
            if(i < allProduct.length){
                
                productID[i] = allProduct[i].getProductId();
                productName[i] = allProduct[i].getProductName();
                productPrice[i] = allProduct[i].getPrice();
                
                    
                System.out.printf("|   |   %-8s | %-25s|   %4d   | %9.2f |   | \n",productID[i], productName[i], stockQuantities[i], productPrice[i]);
    
            }else
                System.out.printf("|   |   %-8s | %-25s|   %4s   |    %6s |   |\n", "", "", "", "");

        }
        
        System.out.printf("|   |--------------------------------------------------------------|   | \n");
        System.out.printf("|   |                                 Total Price(RM): | %9.2f |   | \n", priceTotal);
        System.out.printf("|   +--------------------------------------------------------------+   | \n");        
        System.out.printf("|                                                                      | \n");
        System.out.printf("|______________________________________________________________________| \n");
        System.out.println("");
        
        SystemInput.pauseUntilInput();
    }
   
    public static void viewPOByMonthAndYear(){
        ArrayList<PurchaseOrder> poList = ArrayListLoader.loadPOList();
        
        // Map to store year and an array of month counts (12 months)
        Map<Integer, int[]> yearMonthMap = new HashMap<>();

        for (PurchaseOrder po : poList) {
            String[] duration = po.getDate().split("\\/");
            
            int year = Integer.parseInt(duration[2]); //year is the third element
            int month = Integer.parseInt(duration[1]); //month is the second element
            
            // Initialize the year if not already present
            yearMonthMap.putIfAbsent(year, new int[12]);

            // Increment the count for the respective month (0-indexed, so subtract 1)
            yearMonthMap.get(year)[month - 1]++;
        }

        // Printing the table header
        System.out.println("+======+=======================================================================+");
        System.out.println("| year | Jan | Feb | Mar | Apr | May | Jun | Jul | Aug | Sep | Oct | Nov | Dec |");
        System.out.println("+------|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----+");

        // Iterate through the map and print the PO counts for each year
        for (Map.Entry<Integer, int[]> entry : yearMonthMap.entrySet()) {
            int year = entry.getKey();
            int[] months = entry.getValue();

            System.out.printf("| %d | %2d  | %2d  | %2d  | %2d  | %2d  | %2d  | %2d  | %2d  | %2d  | %2d  | %2d  | %2d  | \n",
                    year, months[0], months[1], months[2], months[3], months[4], months[5],
                    months[6], months[7], months[8], months[9], months[10], months[11]);
        }
        
        System.out.println("+======+=======================================================================+");
        
    }
    
    public static void generatePOReport(ArrayList<PurchaseOrder> poList){
        
        String month = poList.get(0).getDate().substring(3);
        int totalPOs = poList.size();
        
        double totalValue = PODataGetter.getTotalAmountByMonth(poList);
        double averageValue = PODataGetter.getAverageAmountByMonth(poList);
        
        System.out.printf(" ______________________________________________________________________  \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|                       -------------------------                      | \n");
        System.out.printf("|                      |    PO Monthly Report    |                     | \n");
        System.out.printf("|                       -------------------------                      | \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|   Month: %7s                                                     | \n", month);
        System.out.printf("|                                                                      | \n");
        System.out.printf("|   Total Number of POs: %-2d                                            | \n", totalPOs);
        System.out.printf("|                                                                      | \n");
        System.out.printf("|   Total Value of POs : RM %-10.2f                                 | \n", totalValue);
        System.out.printf("|   Average PO Value:  : RM %-10.2f                                 | \n", averageValue);
        System.out.printf("|                                                                      | \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|   PO Status Overview                                                 | \n");
        System.out.printf("|   +--------------------------------------------------------------+   | \n");
        System.out.printf("|   | PO Number |  Supplier Name        | Date       | Status      |   | \n");
        System.out.printf("|   |-----------|-----------------------|------------|-------------|   | \n");
        
        for(PurchaseOrder po:poList){
            
            String status = DocumentStatus.poStatus(po.getStatus());
            System.out.printf("|   |  %5s    |  %-20s | %-10s | %11s |   | \n", po.getNumber(), po.getSupplier().getSupplierName(), po.getDate(), status);
            
        }
    
        System.out.printf("|   +--------------------------------------------------------------+   | \n");
        System.out.printf("|                                                                      | \n");
        System.out.printf("|______________________________________________________________________| \n");
    }
    
    public static void viewAllPo() {
        
        ArrayList<PurchaseOrder> poList = ArrayListLoader.loadPOList();
                
        System.out.println("+==================================================================+");
        System.out.printf("|  %s  |  %-20s  |     %-7s  |   %-7s  | \n", "PO Number", "Supplier Name", "Date", "Status");
        System.out.println("|-------------|------------------------|--------------|------------|");

        for(PurchaseOrder po:poList){
            
            String poNo = po.getNumber();
            String date = po.getDate();
            String suppName = po.getSupplier().getSupplierName();
            String status = DocumentStatus.poStatus(po.getStatus());
            
            
            System.out.printf("|   %-8s  |  %-20s  |  %-10s  | %-10s | \n", poNo, suppName, date, status);
            
        }
        
        System.out.println("+==================================================================+");

    }
    
    public static void viewProcessingPO(){
        
        ArrayList<PurchaseOrder> poList = ArrayListLoader.loadPOList();
                
        System.out.println("+==================================================================+");
        System.out.printf("|  %s  |  %-20s  |     %-7s  |   %-7s  | \n", "PO Number", "Supplier Name", "Date", "Status");
        System.out.println("|-------------|------------------------|--------------|------------|");
        
        
        for(PurchaseOrder po:poList){
            
            if(!po.getStatus()){
                
                String poNo = po.getNumber();
                String date = po.getDate();
                String suppName = po.getSupplier().getSupplierName();
                String status = DocumentStatus.poStatus(po.getStatus());


                System.out.printf("|   %-8s  |  %-20s  |  %-10s  | %-10s | \n", poNo, suppName, date, status);

            }
            
        }
        
        System.out.println("+==================================================================+");

        
    }
    
}
