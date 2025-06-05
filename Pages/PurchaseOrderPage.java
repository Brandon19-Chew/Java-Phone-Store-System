
package Pages;

import Modules.AdminHistoryModule;
import Modules.PurchaseOrderModule;
import Utility.SystemInput;

public class PurchaseOrderPage extends BasePage {
    
    private final PurchaseOrderModule poModule = new PurchaseOrderModule();
    
    @Override
    public void displayMenu(){

        do{
            
            System.out.println("+============================================+");
            System.out.println("|            Purchase Order Menu             |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|                                            |");
            System.out.println("|            1.PO Monthly Report             |");
            System.out.println("|            2.Check PO                      |");
            System.out.println("|            3.Create PO                     |");
            System.out.println("|            4.Cancel PO                     |");
            System.out.println("|            0.Exit                          |");
            System.out.println("|                                            |");
            System.out.println("+============================================+");

            action = SystemInput.inputForSwtich();

            switch(action){
                case 1 -> { poModule.POMonthlyReport();
                            AdminHistoryModule.logAction("Admin checked po monthly report"); // Log action
                }
                case 2 -> { poModule.checkPurchaseOrder();
                            AdminHistoryModule.logAction("Admin checked po details"); // Log action
                }
                case 3 -> { poModule.createPurchaseOrder();
                            AdminHistoryModule.logAction("Admin created new po"); // Log action
                }
                case 4 -> { poModule.cancelPurchaseOrder();
                            AdminHistoryModule.logAction("Admin cancel po"); // Log action
                }
                default -> System.out.println("The digit is invalid, please enter again.");     

                case 0 -> {return;}

            }
        
        
        }while(action != 0);
       
    }
}
