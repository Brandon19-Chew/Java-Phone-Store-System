
package Pages;

import Modules.Admin.AdminAccount;
import Modules.AdminHistoryModule;
import Utility.TextColors;
import Utility.SystemInput;

public class MainPage extends BasePage{
    
    private static final AdminAccount adminAccount = new AdminAccount(); // Create an instance of AdminAccount
    
    private final StockPage stock = new StockPage();
    private final ProductPage product = new ProductPage();
    private final SupplierPage supplier = new SupplierPage();
    private final PurchaseOrderPage po = new PurchaseOrderPage();
    private final DeliveryPage delivery = new DeliveryPage();
    private final PaymentPage payment = new PaymentPage();
            

    @Override
    public void displayMenu() {
        
    int adminOption;
    
        do{
            
            System.out.println(TextColors.ANSI_CYAN + "+============================================+");
            System.out.println(TextColors.ANSI_CYAN + "|--------TAR Tech Accessory Retailer---------|");
            System.out.println(TextColors.ANSI_CYAN + "+--------------------------------------------+");
            System.out.println(TextColors.ANSI_CYAN + "|        1. Stock Management Menu            |");
            System.out.println(TextColors.ANSI_CYAN + "|        2. Product Menu                     |");
            System.out.println(TextColors.ANSI_CYAN + "|        3. Supplier Menu                    |");
            System.out.println(TextColors.ANSI_CYAN + "|        4. Purchase Order Menu              |");
            System.out.println(TextColors.ANSI_CYAN + "|        5. Delivery Management Menu         |");
            System.out.println(TextColors.ANSI_CYAN + "|        6. Payment Management Menu          |");
            System.out.println(TextColors.ANSI_CYAN + "|        7. Admin History (AH)               |");
            System.out.println(TextColors.ANSI_CYAN + "|        0. Logout                           |");
            System.out.println(TextColors.ANSI_CYAN + "|                                            |");
            System.out.println(TextColors.ANSI_CYAN + "+============================================+" + TextColors.ANSI_RESET);

            adminOption = SystemInput.inputForSwtich();

            switch (adminOption) {

                case 1 -> { stock.displayMenu();// Manage stock items
                            AdminHistoryModule.logAction("Admin managed stock items"); // Log action
                }
                case 2 -> { product.displayMenu();
                            AdminHistoryModule.logAction("Admin viewed product management"); // Log action
                }
                
                case 3 -> { supplier.displayMenu();
                            AdminHistoryModule.logAction("Admin viewed supplier management");
                }
                case 4 -> { po.displayMenu();
                            AdminHistoryModule.logAction("Admin managed purchrase order (PO)");
                }
                case 5 -> { delivery.displayMenu();
                            AdminHistoryModule.logAction("Admin managed delivery page");
                }
                case 6 -> { payment.displayMenu();
                            AdminHistoryModule.logAction("Admin managed payment page");
                }
                case 7 -> { AdminHistoryModule.displayHistory(); // Display admin history
                }
                case 0 -> { System.out.println(TextColors.ANSI_GREEN + "Process to logout........" + TextColors.ANSI_RESET);
                
                            adminAccount.logoutAdmin(); // Ensure logout event is recorded
                            
                            return; // Exit the admin management menu
                }
                default -> System.out.println(TextColors.ANSI_RED + "Invalid option! Please try again." + TextColors.ANSI_RESET);
            }
            
        }while(true);
    }

}
