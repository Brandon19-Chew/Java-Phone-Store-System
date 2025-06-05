
package Pages;

import Modules.AdminHistoryModule;
import Modules.SupplierModule;
import Utility.SystemInput;

public class SupplierPage extends BasePage {
    
    private final SupplierModule suppModule = new SupplierModule();
    
    @Override
    public void displayMenu(){
        

        do{
            System.out.println("+============================================+");
            System.out.println("|                Supplier Menu               |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|                                            |");
            System.out.println("|         1.Display Supplier list            |");
            System.out.println("|         2.Add New Supplier                 |");
            System.out.println("|         3.Edit Supplier Details            |");
            System.out.println("|         4.Delete Supplier                  |");
            System.out.println("|         0.Exit                             |");
            System.out.println("|                                            |");
            System.out.println("+============================================+");


            action = SystemInput.inputForSwtich();

            switch(action){
                case 1 -> { suppModule.displaySupplier();
                            AdminHistoryModule.logAction("Admin checked supplier list"); // Log action
                }

                case 2 -> { suppModule.addNewSupplier();
                            AdminHistoryModule.logAction("Admin add new supplier"); // Log action
                }

                case 3 -> { suppModule.editSupplierDetails();
                            AdminHistoryModule.logAction("Admin edit supplier details"); // Log action
                }

                case 4 -> { suppModule.deleteSupplierDetails();
                            AdminHistoryModule.logAction("Admin delete supplier details"); // Log action
                }

                default -> System.out.println("The digit is invalid, please enter again.");     

                case 0 -> {return;}
            }
            
        }while(action != 0);
        
    }   
}
