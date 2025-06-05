
package Utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public static String getCurrentDate(){
        
        //Get current system date
        LocalDate today = LocalDate.now();
        
        String formattedToday = today.format(FORMATTER); //implement the format to system date get from above 
        
        //return with format 00/00/0000
        return formattedToday;
        
    }
    
    public static String getDeliveryDate(int datePlus){
        
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Add days
        LocalDate futureDate = currentDate.plusDays(datePlus);
        String formattedFutureDate = futureDate.format(FORMATTER); //implement the format to system date get from above 

        return formattedFutureDate;
        
    }
    
    public static LocalDate convertStrToDate(String strDate){
        
            // Convert the string to LocalDate
            LocalDate date = LocalDate.parse(strDate, FORMATTER); 
            
            return date;
    }
    
    public static int convertMonthStrToInt(String monthStr){
        
        int months = 0;
        
        switch(monthStr) {
            case "Jan" -> months = 1;
            case "Feb" -> months = 2;
            case "Mar" -> months = 3;
            case "Apr" -> months = 4;
            case "May" -> months = 5;
            case "Jun" -> months = 6;
            case "Jul" -> months = 7;
            case "Aug" -> months = 8;
            case "Sep" -> months = 9;
            case "Oct" -> months = 10;
            case "Nov" -> months = 11;
            case "Dec" -> months = 12;
            default -> System.out.println("Invalid month: " + monthStr + ", please enter valid month.");
        }
        
        return months;
    }
    
}
