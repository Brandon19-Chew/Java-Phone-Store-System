package Modules;

import Utility.FileLocation;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminHistoryModule extends FileLocation{

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Record a login, logout, or stock viewing event
    public static void recordEvent(String event) {
        try (FileWriter fw = new FileWriter(ADMIN_LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String timestamp = DATE_FORMAT.format(new Date());
            bw.write(timestamp + " - " + event);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Display the history
    public static void displayHistory() {
        File historyFile = new File(ADMIN_LOG_FILE);
        if (historyFile.exists()) {
            try (FileReader fr = new FileReader(historyFile);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No history available.");
        }
    }

     public static void logAction(String action) {
        try (FileWriter fw = new FileWriter(ADMIN_LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            bw.write(timestamp + " - " + action);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to history file: " + e.getMessage());
        }
    }
 
      public static void CRUD(String action) {
        try (FileWriter fw = new FileWriter(ADMIN_LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            bw.write(timestamp + " - " + action);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to history file: " + e.getMessage());
        }
    }
}
