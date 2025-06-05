package Pages;

import Modules.AdminHistoryModule;
import Modules.StockModule;
import Utility.SystemInput;
import Utility.TextColors;

public class StockPage extends BasePage{
    
    @Override
    public void displayMenu() {
        TextColors.colors(); // This initializes the color codes
       
        do{

            System.out.println("+============================================+");
            System.out.println("|            Stock Management Menu           |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|               1.View Stock                 |");
            System.out.println("|               2.Add Stock                  |");
            System.out.println("|               3.Update Stock               |");
            System.out.println("|               4.Delete Stock               |");
            System.out.println("|               0.Exit                       |");
            System.out.println("|                                            |");
            System.out.println("+============================================+");

            // Read user input and validate
            action = SystemInput.inputForSwtich();

            switch (action) {
                case 1 -> { StockManagementPage stock = new StockManagementPage();
                            stock.displayMenu();
                }
                case 2 -> { StockModule.addStock();
                            AdminHistoryModule.CRUD("Admin add stocks from (MSI)"); // CRUD action
                }
                case 3 -> {StockModule.updateStock();
                            AdminHistoryModule.CRUD("Admin update stocks from (MSI)"); // CRUD action
                }
                case 4 -> {StockModule.deleteStock();
                            AdminHistoryModule.CRUD("Admin delete stocks from (MSI)"); // CRUD action
                }
                case 0 -> System.out.println(TextColors.ANSI_GREEN + "Returning to Main Menu... Done!" + TextColors.ANSI_RESET);
                default -> System.out.println(TextColors.ANSI_RED + "Invalid option! Please try again." + TextColors.ANSI_RESET);
            }

        }while (action != 0); 
    }
}
