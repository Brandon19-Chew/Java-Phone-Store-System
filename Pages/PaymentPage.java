
package Pages;

import Modules.AdminHistoryModule;
import Modules.PaymentModule;
import Utility.SystemInput;


public class PaymentPage extends BasePage {
    
    @Override
    public void displayMenu(){
             
        do{
            
            System.out.println("+============================================+");
            System.out.println("|           Payment Management Menu          |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|                                            |");
            System.out.println("|              1.Make Payment                |");
            System.out.println("|              2.Current Bills               |");
            System.out.println("|              3.Payment History             |");
            System.out.println("|              0.Exit                        |");
            System.out.println("|                                            |");
            System.out.println("+============================================+");
            action = SystemInput.inputForSwtich();

            switch(action){
                case 1 ->{  PaymentModule.payBill();
                            AdminHistoryModule.logAction("Admin making payment");
                }
                case 2 -> { PaymentModule.checkCurrentBills();
                            AdminHistoryModule.logAction("Admin check current bills"); 
                }
                case 3 -> { PaymentModule.checkPaymentHistory();
                            AdminHistoryModule.logAction("Admin check payment history");
                }
                default ->System.out.println("The digit is invalid, please enter again.");     
                case 0 -> {return;}
            }
        
        }while(action != 0);
        
    }
        
}
