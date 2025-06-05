package Pages;

import Classes.Admin;
import Modules.Admin.AdminAccount;
import Utility.SystemInput;
import Utility.TextColors;

public class AdminPage extends BasePage {
   
    private final AdminAccount adminAccount = new AdminAccount(); // Create an instance of AdminAccount
    private Admin loggedInAdmin = null; // Track the currently logged-in admin
    
    @Override
    public void displayMenu() {
        
        TextColors.colors(); // This initializes the color codes
        
        do{
            
            // Display initial menu for login or registration
            System.out.println(TextColors.ANSI_CYAN + "+============================================+");
            System.out.println(TextColors.ANSI_CYAN + "|        1. Register Admin                   |");
            System.out.println(TextColors.ANSI_CYAN + "|        2. Login                            |");
            System.out.println(TextColors.ANSI_CYAN + "|        0. EXIT PROGRAM                     |");
            System.out.println(TextColors.ANSI_CYAN + "+============================================+" + TextColors.ANSI_RESET);

            action = SystemInput.inputForSwtich();

            switch (action) {
                    // Connect to AdminAccount class and register admin
                case 1 -> adminAccount.registerAdmin(); // Call the registerAdmin() method
                    // Connect to AdminAccount class and login admin
                case 2 -> { adminAccount.loginAdmin(); // Call the loginAdmin() method

                    // Optionally check if login was successful and proceed
                    if (adminAccount.isLoggedIn()) {
                        System.out.println(TextColors.ANSI_GREEN + "Proceeding to Admin Management Menu..." + TextColors.ANSI_RESET);
                        loggedInAdmin = adminAccount.getLoggedInAdmin(); // Set the logged-in admin
                        
                        MainPage main = new MainPage();
                        main.displayMenu();// Proceed to admin management menu if login successful
                        
                    } else {
                        System.out.println(TextColors.ANSI_RED + "Login failed. Try again." + TextColors.ANSI_RESET);
                    }
                }
                case 0 -> {System.out.println(TextColors.ANSI_GREEN + "Exiting program." + TextColors.ANSI_RESET);
                    System.exit(0);
                }
                default -> System.out.println(TextColors.ANSI_RED + "Invalid option. Please try again." + TextColors.ANSI_RESET);
            }
        }while(true);
    }

}
