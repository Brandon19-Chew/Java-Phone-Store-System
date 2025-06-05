
package File.Reader;


import Classes.Payment;
import Utility.DocumentStatus;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PaymentFileReader {
    
        //read for invoice.txt
    public static ArrayList<Payment> readInvoiceFile(String filePath){
        
         ArrayList<Payment> payMenu = new ArrayList<>();       
       
        String invoiceId;
        String dueDate;
        String paymentMethod;
        String paymentDate;
        boolean status;
   
               
        try(FileReader readFile = new FileReader(filePath)){
                
            Scanner fileRead = new Scanner(readFile);
            
            //when scanner has scanned next line
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                               
                //tempolary save to local array
                String[] splitCount = line.split("\\|");
                                
                if(splitCount.length == 5){

                    // Create an invoice object for each line
                    Payment payBills = new Payment();
                    
                    //split the array to correnspond variable
                    invoiceId = splitCount[0];
                    dueDate = splitCount[1];
                    paymentMethod = splitCount[2];
                    paymentDate = splitCount[3];
                    status = DocumentStatus.checkStatus(splitCount[4]);
                    
                    
                    //save to Supplier class
                    payMenu.add(new Payment(invoiceId, dueDate , paymentMethod, paymentDate, status));

                }                
                               
            }
            fileRead.close();
        
        } catch (IOException e) {
            System.out.println("An error occurred when reading supplier file.");
            e.printStackTrace();
        }
        
        System.out.println(payMenu);
       
        return payMenu;
    }
}
