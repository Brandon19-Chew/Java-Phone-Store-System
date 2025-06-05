
package Classes;
import Modules.AdminHistoryModule;

public class AdminAcc {
    private boolean loggedIn = false;

    public void registerAdmin() {
        // Your login logic
        loggedIn = true;
        AdminHistoryModule.recordEvent("Admin account have been created.");
    }

    public void loginAdmin() {
        // Your login logic
        loggedIn = true;
        AdminHistoryModule.recordEvent("Admin logged in.");
    }

    public void logoutAdmin() {
        // Your logout logic
        loggedIn = false;
        AdminHistoryModule.recordEvent("Admin logged out.");
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
