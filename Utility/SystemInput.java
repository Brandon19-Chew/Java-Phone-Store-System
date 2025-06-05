
package Utility;
import java.util.InputMismatchException;

public class SystemInput {

    //Tempolary pause until press Enter key to continue
    public static void pauseUntilInput() {
        
            System.out.print("Press Enter to continue...");

            IO.getScanner().nextLine();  // Pauses until the user presses Enter

    }
    
    
    //Enter "y" to continue, Enter "n" to stop
    public static boolean checkInputCondition(String message){
          
        String condition;
        do{
            System.out.print(message);
            condition = IO.getScanner().nextLine();
            
            if(!condition.equalsIgnoreCase("y") && !condition.equalsIgnoreCase("n"))
                    System.out.println("Please enter properly.");
            
        }while(!condition.equalsIgnoreCase("y") && !condition.equalsIgnoreCase("n"));
        
        if(condition.equalsIgnoreCase("y"))
            return true;
        
        return false;
        
    }
    
    public static int inputForSwtich(){
        int input;
        
        while (true) {
            try {
                System.out.print("Please Enter the digit: ");
                    input = IO.getScanner().nextInt(); // Attempt to read an integer
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                    IO.getScanner().next();  // Clear the invalid input
            }
        }
        
        IO.getScanner().nextLine();
        return input;
    }
    
    public static int inputForInt(){
        int input;
        
        while (true) {
            try {
                    input = IO.getScanner().nextInt(); // Attempt to read an integer
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                    IO.getScanner().next();  // Clear the invalid input
            }
        }
        
        IO.getScanner().nextLine();
        return input;
    }
    
        
}
