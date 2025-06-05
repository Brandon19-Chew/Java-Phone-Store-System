package Utility;

public class TextColors {
    
    public static String ANSI_RESET;
    public static String ANSI_CYAN;
    public static String ANSI_GREEN;
    public static String ANSI_RED;
    
    public static void colors() {
        ANSI_RESET = "\u001B[0m";
        ANSI_CYAN  = "\u001B[36m";
        ANSI_GREEN = "\u001B[32m";
        ANSI_RED   = "\u001B[31m";
    }
}
