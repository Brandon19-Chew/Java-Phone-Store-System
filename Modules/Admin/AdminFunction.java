package Modules.Admin;

import Classes.Admin;
import Utility.FileLocation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminFunction extends FileLocation{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

  
    // Save admin details to file
    public static void saveToFile(int id, String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ADMIN_FILE, true))) {
            writer.write(id + "," + username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error saving admin to file: " + e.getMessage() + ANSI_RESET);
        }
    }

    // Load admin from file by username and password
  public static Admin loadFromFile(int adminID, String username, String password) {
    File file = new File(ADMIN_FILE);

    // Check if file exists
    if (!file.exists()) {
        System.out.println(ANSI_RED + "File not found: admin.txt" + ANSI_RESET);
        return null;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;

        // Read each line from the admin file
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");

            // Ensure the line has the correct number of fields
            if (parts.length == 3) {  // Expecting Admin ID, Username, Password
                int fileAdminID = Integer.parseInt(parts[0]); // Admin ID from file
                String fileUsername = parts[1]; // Username from file
                String filePassword = parts[2]; // Password from file

                // Check if adminID, username, and password match
                if (adminID == fileAdminID && username.equals(fileUsername) && password.equals(filePassword)) {
                    return new Admin(fileAdminID, fileUsername, filePassword); // Return matching Admin object
                }
            }
        }
    } catch (IOException e) {
        System.out.println(ANSI_RED + "Error loading admin from file: " + e.getMessage() + ANSI_RESET);
  }
    // Return null if no matching admin was found
    return null;
  }
}



