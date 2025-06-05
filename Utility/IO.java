
package Utility;

import java.util.Scanner;

public class IO {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }
    
    public static void closeScanner(){
        scanner.close();
    }
    
    public static void openScanner(){
        Scanner scanner = new Scanner(System.in);
    }
    
    
    
}
