package Modules.Admin;

import Classes.Admin;
import Utility.TextColors;
import java.util.InputMismatchException;
import Modules.AdminHistoryModule;
import Utility.IO;

public class AdminAccount {
    private boolean loggedIn = false;
    private Admin loggedInAdmin = null;

    // Public method to register admin
    public void registerAdmin() {
        TextColors.colors(); // This initializes the color codes
        try {
            System.out.print("Enter admin ID (integer): ");
            int adminId = IO.getScanner().nextInt();
            IO.getScanner().nextLine(); // Clear the buffer after reading an int

            System.out.print("Enter username: ");
            String username = IO.getScanner().nextLine();

            System.out.print("Enter password: ");
            String password = IO.getScanner().nextLine();

            Admin newAdmin = new Admin(adminId, username, password);
            AdminFunction.saveToFile(newAdmin.getId(), newAdmin.getUsername(), newAdmin.getPassword());

            System.out.println(TextColors.ANSI_GREEN + "Admin registered successfully!" + TextColors.ANSI_RESET);
        } catch (InputMismatchException e) {
            System.out.println(TextColors.ANSI_RED + "Invalid input for admin ID ! Please enter a valid integer." + TextColors.ANSI_RESET);
            IO.getScanner().nextLine(); // Clear buffer to avoid infinite loop
        } catch (Exception e) {
            System.out.println(TextColors.ANSI_RED + "An unexpected error occurred: " + e.getMessage() + TextColors.ANSI_RESET);
        }
    }

    // Public method to login admin
    public void loginAdmin() {
        
    int loginAdminID = -1;
    boolean validInput = false;
    
        while (!validInput) {
        System.out.print("Enter Admin ID (integer): ");
        if (IO.getScanner().hasNextInt()) {
            loginAdminID = IO.getScanner().nextInt();
            IO.getScanner().nextLine(); // Clear buffer after reading an int
            validInput = true;
        } else {
            System.out.println(TextColors.ANSI_RED + "Only numbers are allowed for Admin ID! Try again." + TextColors.ANSI_RESET);
            IO.getScanner().nextLine(); // Clear the buffer to avoid an infinite loop
        }
    }

        System.out.print("Enter username: ");
        String loginUsername = IO.getScanner().nextLine();

        System.out.print("Enter password: ");
        String loginPassword = IO.getScanner().nextLine();

        // Check if credentials are valid by loading from file
        loggedInAdmin = AdminFunction.loadFromFile(loginAdminID, loginUsername, loginPassword);

        if (loggedInAdmin != null) {
            System.out.println(TextColors.ANSI_GREEN + "Login successful!" + TextColors.ANSI_RESET);
            loggedIn = true;
            AdminHistoryModule.recordEvent("Admin [Username: " + loginUsername + "] logged in");  // Log login action
        } else {
            System.out.println(TextColors.ANSI_RED + "Invalid username or password. Please try again." + TextColors.ANSI_RESET);
            AdminHistoryModule.recordEvent("Failed login attempt for username: " + loginUsername);  // Log failed login attempt
        }
    }

  // Public method to logout admin
    public void logoutAdmin() {
        if (loggedIn) {
            System.out.println(TextColors.ANSI_GREEN + "Logging out... Successfully" + TextColors.ANSI_RESET);
            AdminHistoryModule.recordEvent("Admin logged out.");  // Log logout action
            loggedIn = false;
        } else {
            System.out.println(TextColors.ANSI_RED + "No admin is currently logged in." + TextColors.ANSI_RESET);
        }
    }
   
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Admin getLoggedInAdmin() {
        return loggedInAdmin;
    }
}
