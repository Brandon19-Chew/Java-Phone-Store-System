package Pages;

import Utility.TextColors;
import Modules.AdminHistoryModule;
import Utility.SystemInput;
import View.StockView;

public class StockManagementPage extends BasePage {

    @Override
    public void displayMenu() {
        // Initialize colors by calling the method from TextColors class
        TextColors.colors(); // This initializes the color codes


        do{
            System.out.println(TextColors.ANSI_CYAN + "|--------------------------------------------|");
            System.out.println(TextColors.ANSI_CYAN + "|        View Stock Management Menu          |");
            System.out.println(TextColors.ANSI_CYAN + "|--------------------------------------------|");
            System.out.println(TextColors.ANSI_CYAN + "|        1. View All Stocks                  |");
            System.out.println(TextColors.ANSI_CYAN + "|        2. View Stock by Category           |");
            System.out.println(TextColors.ANSI_CYAN + "|        3. View Stock by ID                 |");
            System.out.println(TextColors.ANSI_CYAN + "|        0. Back to Main Menu                |");
            System.out.println(TextColors.ANSI_CYAN + "|____________________________________________|" + TextColors.ANSI_RESET);

            action = SystemInput.inputForSwtich();

            switch (action) {
                case 1 -> { StockView.viewAllStocks(); // Pass username if needed
                            AdminHistoryModule.logAction("Admin viewed all stocks from (VSM)"); // Log action
                }
                case 2 -> { StockView.viewStockByCategory(); // Pass username if needed
                    AdminHistoryModule.logAction("Admin viewed stock by category from (VSM)"); // Log action
                }
                case 3 -> { StockView.viewStockByProductIDAndCategory(); // Pass username if needed
                            AdminHistoryModule.logAction("Admin viewed stock by ID (VSM) "); // Log action
                }
                case 0 -> System.out.println(TextColors.ANSI_GREEN + "Returning to Main Menu... Done!" + TextColors.ANSI_RESET);
                
                default -> System.out.println(TextColors.ANSI_RED + "Invalid option! Please try again." + TextColors.ANSI_RESET);
            }

        }while (action != 0) ;
    }
}
