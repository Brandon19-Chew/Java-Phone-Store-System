package Modules;

import Classes.Product;
import Utility.IO;
import Utility.ArrayListLoader;
import Utility.SystemInput;
import Data.Getter.PODataGetter;
import Data.Getter.SupplierDataGetter;
import Classes.PurchaseOrder;
import Classes.Supplier;
import Data.Input.PODataInput;
import Data.Input.SupplierDataInput;
import Utility.DateGenerator;
import Utility.IDGenerator;
import Utility.ArrayListSaver;
import View.PurchaseOrderView;
import View.SupplierView;
import java.util.ArrayList;


public class PurchaseOrderModule {
    
    private ArrayList<PurchaseOrder> poList;

    
    public void POMonthlyReport(){
        
        poList = ArrayListLoader.loadPOList();

        
        ArrayList<PurchaseOrder> poListByMonth;
        int year, month;
        String monthStr;
        
        PurchaseOrderView.viewPOByMonthAndYear();
        
        do{
            System.out.print("Enter the year : ");
             year = IO.getScanner().nextInt();
             
             //consume enter
             IO.getScanner().nextLine();
             
            if(year > 2024 || year < 2020)
                System.out.println("Please enter valid year.");
             
        }while(year > 2024 || year < 2020);       
        
        do{
            System.out.print("Enter the month : ");
             monthStr = IO.getScanner().nextLine();
             
            month = DateGenerator.convertMonthStrToInt(monthStr);
             
        }while(month > 12 || month < 1);
        
        poListByMonth = PODataGetter.getPOListByMonth(year, month);
        
        if(!poListByMonth.isEmpty())
            PurchaseOrderView.generatePOReport(poListByMonth);
        
        SystemInput.pauseUntilInput();
        
    }

    
    public void checkPurchaseOrder(){
        
        poList = ArrayListLoader.loadPOList();
        String poNum;
        
        if(!poList.isEmpty()){
            
            PurchaseOrderView.viewAllPo();

            if(SystemInput.checkInputCondition("Do you whant to check details? (y/n) : ")){

                poNum = PODataInput.checkPONumberInput();
                PurchaseOrderView.generatePo(poNum);

            }
        }else
            System.out.println("No record Found. ");
        
    }

       
    public void createPurchaseOrder(){
                
        poList = ArrayListLoader.loadPOList();
        String selectSuppID;
        String selectProdID;

        //add 1 to new PO number
        String newPONo = IDGenerator.GeneratePONumber(poList);

        int prodIndex;
        int quantity;
        
        String date = DateGenerator.getCurrentDate();

        PurchaseOrder order = new PurchaseOrder(newPONo, date, false);
        
        System.out.println("");
        System.out.println("Generate new PO number : " + newPONo);
        
        SupplierView.viewAllSupplier();
        
        selectSuppID = SupplierDataInput.checkSupplierIDInput();
        
        SupplierView.viewSupplierByID(selectSuppID);
        
        String[] checkProdID = new String[10];
        int count = 0;
        boolean checkRepeat = false;
        
        do{
            
            do{
                selectProdID = SupplierDataInput.checkProductIDInSupplierInput(selectSuppID);
                
                if(count != 0){
                    for(int i = 0; i < count; i++){
                        if(checkProdID[i].equals(selectProdID)){
                            System.out.println("You cannot buy the same product twice. Please try again.");
                            checkRepeat = true;
                            break;
                        }else
                            checkRepeat = false;
                    }
                }
                                
            }while(checkRepeat);

            
            prodIndex = SupplierDataGetter.getProductIndex(selectSuppID, selectProdID);

            quantity = PODataInput.checkStockQuantity();
            
            System.out.println("");
            System.out.println("Product ID : " + selectProdID + "\n" + "Quantity : " + quantity + "\n");
            
            if(SystemInput.checkInputCondition("Comfirm? (y/n) : ")){

                Product product = SupplierDataGetter.getProductByIndex(selectSuppID, prodIndex);
                
                Supplier supplier = SupplierDataGetter.getAllSupplier(selectSuppID);
                
                order.setSupplier(supplier);

                order.addProduct(product, quantity);

                double totalPrice = order.getTotalPricesByProduct(product);
                order.setTotalPrices(totalPrice);  // Update the total price of the order

                checkProdID[count] = selectProdID;
                count++;
                    
            }else{
                System.out.println("Order cancelled. \n");
            }
                                        
        }while(SystemInput.checkInputCondition("Do you want to continue order? (y/n) : "));
        
        if(!order.getStocks().isEmpty()){
            poList.add(order);
            ArrayListSaver.savePOList(poList);

            PurchaseOrderView.generatePo(newPONo);
            
        }
        
        
    }
               
    
    public void cancelPurchaseOrder(){
                
        poList = ArrayListLoader.loadPOList();
        PurchaseOrderView.viewProcessingPO();
        String poNum;
        
        poNum = PODataInput.checkPONumberStatusInput();
        
        
        if(SystemInput.checkInputCondition("Do you sure to cancel " + poNum + " ? (y/n) : ")){
            
            for(int i = 0; i < poList.size(); i++){
                if(poList.get(i).getNumber().equals(poNum)){
                   poList.remove(i);
                   break;
                }
            }
            
            ArrayListSaver.savePOList(poList);
            System.out.println("Cancel successful.");
            SystemInput.pauseUntilInput();
            
        }else{
            
            System.out.println("Deletion canceled.");
            SystemInput.pauseUntilInput();
            
        }

    }
    
}
