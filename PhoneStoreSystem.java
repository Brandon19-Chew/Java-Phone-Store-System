import Utility.TextColors;
import Pages.AdminPage;
import Utility.IO;
import Utility.SystemInput;


public class PhoneStoreSystem {

    public static void main(String[] args) {
        TextColors.colors(); // This initializes the color codes
        IO.openScanner();

        // Welcome message
        System.out.println("============================================================================");
        System.out.println("*   _______     ___     _______     _______   ______   ______   __   __    *");
        System.out.println("*  |__   __|   /   \\   |   _   |   |__   __| |   ___| |   ___| |  | |  |   *");
        System.out.println("*     | |     /  _  \\  |  |_|  |      | |    |  |___  |  |     |  |_|  |   *");
        System.out.println("*     | |    |  |_|  | |      _|      | |    |   ___| |  |     |   _   |   *");
        System.out.println("*     | |    |   _   | |   _  \\       | |    |  |___  |  |___  |  | |  |   *");
        System.out.println("*     |_|    |__| |__| |__| |__|      |_|    |______| |______| |__| |__|   *");
        System.out.println("*                                                                          *");
        System.out.println("*                                                                          *");
        System.out.println("*                       TAR Tech Accessory Retailer                        *");
        System.out.println("*                                                                          *");
        System.out.println("============================================================================");
    
        
        // Admin history (most login, capture times & date)
        System.out.println(TextColors.ANSI_CYAN + "+============================================+");
        System.out.println(TextColors.ANSI_CYAN + "|             1. Admin Identification        |");
        System.out.println(TextColors.ANSI_CYAN + "|             0. EXIT PROGRAM!               |");
        System.out.println(TextColors.ANSI_CYAN + "+============================================+" + TextColors.ANSI_RESET);
        
        boolean adminLoggedIn = false;
        
        do {
            
            int choice = SystemInput.inputForSwtich();

            switch (choice) {
                case 1:
                    // Admin identification logic
                    System.out.print("Enter admin password: ");
                    String adminPassword = IO.getScanner().nextLine();

                    if (adminPassword.equals("TARTechTheBest")) {
                        // Admin identified successfully
                        adminLoggedIn = true;
                        System.out.println(TextColors.ANSI_GREEN + "Admin logged in successfully!" + TextColors.ANSI_RESET);
                        AdminPage adminMenu = new AdminPage();
                        adminMenu.displayMenu();// Call the AdminMenu
                    } else {
                        System.out.println(TextColors.ANSI_RED + "Incorrect password. Please try again." + TextColors.ANSI_RESET);
                    }
                    break;

                case 0:
                    // Exit program
                    System.out.println(TextColors.ANSI_GREEN + "Exiting Program ... Done!" + TextColors.ANSI_RESET);        
                    IO.closeScanner();
                    System.exit(0);
                    break;

                default:
                    System.out.println(TextColors.ANSI_RED + "Invalid choice. Please try again." + TextColors.ANSI_RESET);
                    break;
            }
        } while (!adminLoggedIn);

    }
}
