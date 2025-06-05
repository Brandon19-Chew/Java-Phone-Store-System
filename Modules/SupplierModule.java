
package Modules;
import Utility.ArrayListSaver;
import Utility.SystemInput;
import Utility.ArrayListLoader;
import Data.Getter.SupplierDataGetter;
import Data.Getter.ProductDataGetter;
import Classes.Supplier;
import Classes.Product;
import Data.Input.ProductDataInput;
import Data.Input.SupplierDataInput;
import Utility.IDGenerator;
import View.SupplierView;
import java.util.ArrayList;


public class SupplierModule {
    
    private ArrayList<Supplier> supplierList;
    
    
    public void displaySupplier(){
        
        supplierList = ArrayListLoader.loadSupplierList();
        int action;
        
        if(!supplierList.isEmpty()){
                       
            SupplierView.viewAllSupplier();
            
            if(SystemInput.checkInputCondition("Do you want to further check ? (y/n) : ")){
                
                SupplierView.displaycheckProductMenu();
                
                action = SystemInput.inputForSwtich();
                
                switch(action){
                    case 1 ->   SupplierView.viewAllProduct();
                    case 2 ->{  
                                String suppID = SupplierDataInput.checkSupplierIDInput();
                                SupplierView.viewSupplierByID(suppID);
                    } 
                }
                    
                
                
                SystemInput.pauseUntilInput();
            }
            
        }else{
            System.out.println("No Supplier in record !");
            
        }
                        
    } 
    
    public void addNewSupplier(){
        supplierList = ArrayListLoader.loadSupplierList();
        ArrayList<Product> prodList = ArrayListLoader.loadProductList();

        String addSuppName;
        String addPhoneNo;
        String addEmail;
        String addAddress;
        
        Supplier supp;
                
        //product
        String addProductName;
        double addPrice;
        
        String newSuppID = IDGenerator.GenerateSupplierID(supplierList);
        
        System.out.println("");
        System.out.println("Generate new Supplier ID: " + newSuppID);
        
        // display guide
        SupplierView.displayAddSupplierGuide();
               
        //Supplier name loop
        addSuppName = SupplierDataInput.checkSupplierNameInput();
        
        //Email loop
        addEmail = SupplierDataInput.checkSupplierEmailInput();
        
        //Phone Number loop
        addPhoneNo = SupplierDataInput.checkSupplierPhNoInput();
        
        //Local Address loop
        addAddress = SupplierDataInput.checkSupplierAddressInput();
        
        Product[] addSupplyGoods = new Product[10];
            
        supp = new Supplier(newSuppID, addSuppName, addEmail, addPhoneNo, addAddress, addSupplyGoods);

        int count = 0;

        do{
            
            String newProdID = IDGenerator.GenerateProductID(prodList);

            System.out.println("");
            System.out.println("Generate new Product ID: " + newProdID);
            
            addProductName = ProductDataInput.checkProductNameInput();
            
            addPrice = ProductDataInput.checkProductPriceInput();
            
            
            if(!addProductName.isEmpty() && addPrice >= 0d){
                
                Product prod = new Product(newProdID, addProductName, addPrice);
                
                supp.addProduct(prod, count);
                prodList.add(prod);
                count += 1;                
                
            }
            
        }while(SystemInput.checkInputCondition("Do you want to add more? (y/n) : "));
        
        if(SystemInput.checkInputCondition("Do you confirm to add new Supplier? (y/n) : ")){
            
            supplierList.add(supp);

            ArrayListSaver.saveProductList(prodList);
            ArrayListSaver.saveSupplierList(supplierList);
            System.out.println("Added Successfully!");
        }else
            System.out.println("Addition Cancelled.");
        
        SystemInput.pauseUntilInput();
        
    }
    
    public void editSupplierDetails(){
      
        supplierList = ArrayListLoader.loadSupplierList();
        String needID;
        int suppIDIndex;
        int action; 
        
        SupplierView.viewAllSupplier();
        
        needID = SupplierDataInput.checkSupplierIDInput();
   
        suppIDIndex = SupplierDataGetter.getSupplierIDIndex(needID);
        
        do{
            //table
            SupplierView.displayEditSupplierMenu();
            
            action = SystemInput.inputForSwtich();
            
            switch(action){
 
                case 1 -> { String newName;
                            String currentName = SupplierDataGetter.getSupplierName(needID);
                            System.out.println("Current name : " + currentName);
                            newName = SupplierDataInput.checkSupplierNameInput();
                            
                            if(SystemInput.checkInputCondition("Do you sure change supplier name from " + currentName + " to " + newName + " ? (y/n) : " )){
                                
                                supplierList.get(suppIDIndex).setSupplierName(newName);
                                editSuccess();
                                SystemInput.pauseUntilInput();
                            }else
                                editCancel();
                            
                }
                    
                case 2 -> { String newEmail;
                            String currentEmail = SupplierDataGetter.getSupplierEmail(needID);
                            
                            System.out.println("Current email : " + currentEmail);
                            newEmail = SupplierDataInput.checkSupplierEmailInput();
                            
                            if(SystemInput.checkInputCondition("Do you sure change supplier email from " + currentEmail + " to " + newEmail + " ? (y/n) : " )){

                                supplierList.get(suppIDIndex).setEmail(newEmail);
                                editSuccess();
                                SystemInput.pauseUntilInput();
                            }else
                                editCancel();
                }
                    
                case 3 -> { String newPhNo;
                            String currentPhNo = SupplierDataGetter.getSupplierPhoneNo(needID);
                            
                            System.out.println("Current Phone no : " + currentPhNo);
                            newPhNo = SupplierDataInput.checkSupplierPhNoInput();
                            
                            if(SystemInput.checkInputCondition("Do you sure change phone number from " + currentPhNo + " to " + newPhNo + " ? (y/n) : " )){
                           
                                supplierList.get(suppIDIndex).setPhoneNo(newPhNo);
                                editSuccess();
                                SystemInput.pauseUntilInput();
                            }else
                                editCancel();
                }
                    
                case 4 -> { String newAddress;
                            String currentAddress = SupplierDataGetter.getSupplierAddress(needID);
                            
                            System.out.println("Current Phone no : " + currentAddress);
                            newAddress = SupplierDataInput.checkSupplierAddressInput();
                            
                            if(SystemInput.checkInputCondition("Do you sure change supplier address from " + currentAddress + " to " + newAddress + " ? (y/n) : " )){

                                supplierList.get(suppIDIndex).setAddress(newAddress);
                                editSuccess();
                                SystemInput.pauseUntilInput();
                            }else
                                editCancel();
                }
                    
                case 5 -> { do{
                                supplierList = ArrayListLoader.loadSupplierList();
                                ArrayList<Product> prodList = ArrayListLoader.loadProductList();
                                SupplierView.viewProducByIndex(suppIDIndex);
                                String productID;

                                productID = SupplierDataInput.checkProductIDInSupplierInput(needID);

                                int productIndex = ProductDataGetter.getProductIndex(productID);

                                SupplierView.displayEditProductMenu();

                                action = SystemInput.inputForSwtich();

                                switch(action){
                                    case 1 ->{  String newProductName;
                                                String currentProdName = ProductDataGetter.getProductName(productID);
                                                System.out.println("Current Product Name : " + currentProdName);
                                                newProductName = ProductDataInput.checkProductNameInput();
                                                
                                                if(SystemInput.checkInputCondition("Do you sure change product name from " + currentProdName + " to " + newProductName + " ? (y/n) : " )){
                                                  
                                                    prodList.get(productIndex).setProductName(newProductName);
                                                    editSuccess();
                                                }else
                                                    editCancel();

                                    }
                                    case 2 -> { double newProductPrice;
                                                String currentPrice = String.format("%.2f", ProductDataGetter.getProductPrice(productID));
                                                System.out.println("Current Unit Price : RM" + currentPrice);
                                                newProductPrice = ProductDataInput.checkProductPriceInput();
                                                
                                                String newPrice = String.format("%.2f", newProductPrice);
                                                
                                                if(SystemInput.checkInputCondition("Do you sure change unit price from RM" + currentPrice + " to RM" + newPrice + " ? (y/n) : " )){
                                                    prodList.get(productIndex).setPrice(newProductPrice);
                                                    editSuccess();
                                                }else
                                                    editCancel();
                            }

                        }
                        
                        ArrayListSaver.saveProductList(prodList);
                        
                        

                    }while(SystemInput.checkInputCondition("Do you want to continue edit? (y/n) : "));    
                }
                case 0 ->{return;}                
                default -> System.out.println("The Action is Invalid, Please Try Again.");
            }
      }while(action != 0);
          
    }
    
    public void deleteSupplierDetails(){
       
        supplierList = ArrayListLoader.loadSupplierList();
        ArrayList<Product> productList = ArrayListLoader.loadProductList();
        String needID;
        int suppIndex;
        
        SupplierView.viewAllSupplier();
        
        needID = SupplierDataInput.checkSupplierIDInput();

        suppIndex = SupplierDataGetter.getSupplierIDIndex(needID);
        
        SupplierView.viewSupplierByID(needID);
        
        SupplierView.displayDeleteSupplierMenu();

        int action = SystemInput.inputForSwtich();

        switch(action){
            case 1 -> {
                        if(SystemInput.checkInputCondition("Do you sure to delete " + needID + " ? (y/n) : ")){

                            Product[] prodIDsFromSupp = supplierList.get(suppIndex).getProductList();


                            for(int i = 0, j = 0;i < productList.size(); i++){
                                productList.get(i).getProductId();

                                if(prodIDsFromSupp[j].getProductId().equals(productList.get(i).getProductId())){
                                    productList.remove(i);
                                    j++;
                                    i--;
                                }
                            }

                            supplierList.remove(suppIndex);
                            ArrayListSaver.saveProductList(productList);
                            ArrayListSaver.saveSupplierList(supplierList);

                            System.out.println("Delete successful.");
                            SystemInput.pauseUntilInput();
                            
                        }else{

                            System.out.println("Deletion canceled.");
                            SystemInput.pauseUntilInput();
                            
                }
            }
            case 2 -> { SupplierView.viewProducByIndex(suppIndex);
                        String prodID;
                        
                        prodID = SupplierDataInput.checkProductIDInSupplierInput(needID);
                        
                        int suppProdIndex = SupplierDataGetter.getProductIndex(needID, prodID);
                        int productIndex = ProductDataGetter.getProductIndex(prodID);

                        if(SystemInput.checkInputCondition("Do you sure to delete " + prodID + " ? (y/n) : ")){

                            Supplier supp = supplierList.get(suppIndex);

                            supp.removeProduct(suppProdIndex);

                            supplierList.set(suppIndex, supp);

                            productList.remove(productIndex);

                            ArrayListSaver.saveSupplierList(supplierList);
                            ArrayListSaver.saveProductList(productList);
                            System.out.println("Delete successful.");
                            SystemInput.pauseUntilInput();

                        }else{
                            System.out.println("Deletion canceled.");
                            SystemInput.pauseUntilInput();
                        }

            }
            default -> System.out.println("The Action is Invalid, Please Try Again.");
        }
    }
    
    
    private static void editSuccess(){
        
        System.out.println("Edit Successfully.");
        
    }   
    
    private static void editCancel(){
        
        System.out.println("Edit Cancelled");
        
    }
            
}