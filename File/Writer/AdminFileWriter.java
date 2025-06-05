package File.Writer;

import Classes.Admin;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdminFileWriter {
     // Write Admin data to admin.txt
    public static void writeAdminFile(String filePath, ArrayList<Admin> adminList){
        try (FileWriter writeFile = new FileWriter(filePath)) {
            for (Admin admin : adminList) {
                String id = String.valueOf(admin.getId());
                String username = admin.getUsername();
                String password = admin.getPassword();

                String format = id + "|" + username + "|" + password + "\n";
                writeFile.write(format);
            }      
        } catch (IOException e) {
            System.out.println("An error occurred when writing admin file.");
        }
    }
         
    
    
}
