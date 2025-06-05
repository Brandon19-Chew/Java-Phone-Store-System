
package View;

import Data.Getter.SupplierDataGetter;
import Classes.Product;
import Classes.Supplier;
import Utility.ArrayListLoader;
import java.util.ArrayList;

public class SupplierView {
    
    
    public static void viewAllSupplier(){
        
        ArrayList<Supplier> supplierList = ArrayListLoader.loadSupplierList();
        
        String suppID; 
        String name;
        String phoneNo;
        String address;
        String email;
        Product[] supplyGoods;
        String productID = null;
                
                       
            System.out.println("+=======================================================================================================================================================================================+");
            System.out.println("| Supplier ID |  Suppler Name         |   email                   | Phone Number   |       Address                                                     | Supply Goods                   |");
            System.out.println("|-------------|-----------------------|---------------------------|----------------|-------------------------------------------------------------------|--------------------------------|");
            for(Supplier supplier : supplierList)  {
                           
                suppID= supplier.getSupplierID();                    
                name = supplier.getSupplierName();
                email = supplier.getEmail();
                phoneNo = supplier.getPhoneNo();
                address = supplier.getAddress();
                supplyGoods = supplier.getProductList();
                
                if(supplyGoods.length == 1){
                    productID = supplyGoods[0].getProductId();

                }else{
                    
                    productID = supplyGoods[0].getProductId();

                    for(int i = 1; i < supplyGoods.length; i++){
                        productID += "," + supplyGoods[i].getProductId();

                    }
                }

               String format = "|    %-8s |  %-20s | %-25s | %-14s |  %-64s | %-30s |%n";
                
               System.out.printf(format, suppID, name, email, phoneNo, address , productID);
                 
             } 

            System.out.println("+=======================================================================================================================================================================================+");
            System.out.println("");

    }
    
    public static void viewAllProduct(){


        ArrayList<Product> prodList = ArrayListLoader.loadProductList();

        System.out.println("+======================================================+");
        System.out.println("| Product ID |     Product Name           | Price (RM) |");
        System.out.println("|------------|----------------------------|------------|");

        String prodID;
        String prodName;
        double prodPrice;

        for(Product prod : prodList){

            prodID = prod.getProductId();
            prodName = prod.getProductName();
            prodPrice = prod.getPrice();

            System.out.printf("| %-10s |  %-25s | %-10.2f | \n", prodID, prodName, prodPrice);

        }

        System.out.println("+======================================================+");
        System.out.println("");

    }
        
    public static void viewSupplierByID(String suppID){
        
        
        System.out.println("");
        System.out.println("+======================================================================================================================================================+");
        System.out.println("| Supplier ID |  Suppler Name         |   email                   | Phone Number   |       Address                                                     |");
        System.out.println("|-------------|-----------------------|---------------------------|----------------|-------------------------------------------------------------------|");
        System.out.printf("|    %-8s |  %-20s | %-25s | %-14s |  %-64s |%n", suppID, SupplierDataGetter.getSupplierName(suppID), SupplierDataGetter.getSupplierEmail(suppID), SupplierDataGetter.getSupplierPhoneNo(suppID), SupplierDataGetter.getSupplierAddress(suppID));
        System.out.println("+======================================================================================================================================================+");
        System.out.println("| Product ID |     Product Name           | Price (RM) |");
        System.out.println("|------------|----------------------------|------------|");
        
        Product[] products = SupplierDataGetter.getProducts(suppID);
        
        for(int i = 0; i < products.length; i++){

            String prodID = products[i].getProductId();
            String prodName = products[i].getProductName();
            double price = products[i].getPrice();

            System.out.printf("| %-10s |  %-25s | %-10.2f | \n", prodID, prodName, price);

        }

        System.out.println("+======================================================+");
        System.out.println("");

        
        
        
        
    }
    
    public static void viewProducByIndex(int suppIndex){

        ArrayList<Supplier> supplierList = ArrayListLoader.loadSupplierList();

        System.out.println("+======================================================+");
        System.out.println("| Product ID |     Product Name           | Price (RM) |");
        System.out.println("|------------|----------------------------|------------|");

        for(int i = 0; i < supplierList.get(suppIndex).getProductList().length; i++){

            Product[] prod = supplierList.get(suppIndex).getProductList();

            String prodID = prod[i].getProductId();
            String prodName = prod[i].getProductName();
            double price = prod[i].getPrice();

            System.out.printf("| %-10s |  %-25s | %-10.2f | \n", prodID, prodName, price);

        }

        System.out.println("+======================================================+");
        System.out.println("");
    }

    public static final void displaycheckProductMenu(){
        
        System.out.println("+=======================================+");
        System.out.println("|   1.All Product List                  |");
        System.out.println("|   2.Products by Supplier ID           |");
        System.out.println("+=======================================+");
        System.out.println("");
        
    }
    
    public static final void displayAddSupplierGuide(){
        
        System.out.println("+===============================================+");
        System.out.println("|                                               |");
        System.out.println("|   1.Supplier Name: (<20 characters)           |");
        System.out.println("|   2.Email: XXX@XXXXX.com (<20 characters)     |");
        System.out.println("|   3.PhoneNo: 01X-XXXXXXX(10 digit)            |");
        System.out.println("|   4.Address: (<60 characters)                 |");
        System.out.println("|   5.Supply Goods:                             |");
        System.out.println("|     Product Name: (<20 characters)            |");
        System.out.println("|     Price:(<RM10000)                          |");
        System.out.println("|                                               |");
        System.out.println("+===============================================+");
        System.out.println("");
        
    }
    
    public static final void displayEditSupplierMenu(){
        
        System.out.println("+===============================================+");
        System.out.println("|                                               |");
        System.out.println("|   1.Supplier Name: (<20 characters)           |");
        System.out.println("|   2.Email: XXX@XXXXX.com (<20 characters)     |");
        System.out.println("|   3.PhoneNo: 01X-XXXXXXX(10 digit)            |");
        System.out.println("|   4.Address: (<60 characters)                 |");
        System.out.println("|   5.Supply Goods:                             |");
        System.out.println("|     Product Name: (<20 characters)            |");
        System.out.println("|     Price:(<RM10000)                          |");
        System.out.println("|   0.Exit                                      |");
        System.out.println("|                                               |");
        System.out.println("+===============================================+");
        System.out.println("");
    }
    
    public static final void displayEditProductMenu(){
        
        System.out.println("+=======================================+");
        System.out.println("|   1.Product Name                      |");
        System.out.println("|   2.Price                             |");
        System.out.println("+=======================================+");
        System.out.println("");
    }
    
    public static final void displayDeleteSupplierMenu(){
        
        System.out.println("+=======================================+");
        System.out.println("|   1.Supplier Data                     |");
        System.out.println("|   2.Product Data                      |");
        System.out.println("+=======================================+");
        System.out.println("");
    }
    
}
