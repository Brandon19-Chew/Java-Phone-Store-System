

import Modules.AdminHistoryModule;
import Pages.*;
import Utility.IO;
import Utility.SystemInput;

public class Driver {

    private static int action;
    
    
    public static void DisplayMainMenu(){
                      
        IO.openScanner();
        
        do{
            action = -1;
            
            System.out.println("=========================================");
            System.out.println("|				  	|");
            System.out.println("|	1.Product & Category	  	|");            
            System.out.println("|	2.Suppliers Details	  	|");
            System.out.println("|	3.Purchase Order(PO)	  	|");
            System.out.println("|	4.Delivery Order(DO)		|");
            System.out.println("|	5.Goods Receipt/Invoice Receipt |");
            System.out.println("|       6.Admin History                 |");
            System.out.println("|	0.Exit			  	|");
            System.out.println("|				  	|");
            System.out.println("=========================================");

            action = SystemInput.inputForSwtich();

            switch(action){
                case 1:
                    ProductPage prodMenu = new ProductPage();
                    prodMenu.displayMenu();
                    break;
                case 2:
                    SupplierPage suppMenu = new SupplierPage();
                    suppMenu.displayMenu();
                    break;
                case 3:
                    PurchaseOrderPage poMenu = new PurchaseOrderPage();
                    poMenu.displayMenu();
                    break;
                case 4:
                    DeliveryPage deMenu = new DeliveryPage();
                    deMenu.displayMenu();
                    break;
                case 5:
                    PaymentPage payMenu = new PaymentPage();
                    payMenu.displayMenu();
                    break;
                case 6:
                    AdminHistoryModule.displayHistory();
                    break;
                default:
                    System.out.println("The digit is invalid, please enter again.");     
                    break;
                case 0:
                    IO.closeScanner();
                    break;
            }
       
        }while(true);
        
        

    }
    
    public static void main(String[] args) {
        
        DisplayMainMenu();
        
    }
    
}
