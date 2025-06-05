package File.Reader;

import Classes.Admin;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdminFileReader {
     // Read Admin data from admin.txt
    public static ArrayList<Admin> readAdminFile(String filePath) {
        ArrayList<Admin> adminList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String username = parts[1];
                    String password = parts[2];
                    Admin admin = new Admin(id, username, password);
                    adminList.add(admin);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred when reading admin file.");
        }
        return adminList;
    }
   

}
