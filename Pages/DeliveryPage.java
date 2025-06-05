
package Pages;

import Modules.AdminHistoryModule;
import Modules.DeliveryModule;
import static Pages.BasePage.action;
import Utility.SystemInput;


public class DeliveryPage extends BasePage {
    
    @Override
    public  void displayMenu(){
        
        do{
            
            System.out.println("+============================================+");
            System.out.println("|           Delivery Management Menu         |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|                                            |");
            System.out.println("|              1.DO history                  |");
            System.out.println("|              0.Exit                        |");
            System.out.println("|                                            |");
            System.out.println("+============================================+");
            
            action = SystemInput.inputForSwtich();

            switch(action){
                case 1 ->{ DeliveryModule.displayDeliveryStatus();
                          AdminHistoryModule.logAction("Admin managed Delivery history");
                }
               default -> System.out.println("The digit is invalid, please enter again.");     
                case 0 -> {return;}
            }
        
        }while(action != 0);
        
    }
    
}
