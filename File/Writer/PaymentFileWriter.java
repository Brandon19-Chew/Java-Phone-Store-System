
package File.Writer;

import Classes.Payment;
import Utility.DocumentStatus;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class PaymentFileWriter {
    public static void writePayFile(String filePath, ArrayList<Payment> payMenu){

        try(FileWriter writeFile = new FileWriter(filePath)){
            
            for(Payment pay : payMenu){
            
                           
                String invoiceId = pay.getNumber();
                String dueDate = pay.getPaymentDate();
                String paymentMethod = pay.getPaymentMethod();
                String paymentDate = pay.getPaymentDate();
                String status = DocumentStatus.poStatus(pay.getStatus());

                String format = invoiceId + "|" + dueDate + "|" + paymentMethod + "|" + paymentDate + "|" + status + "\n";
                
                writeFile.write(format);
        }
                                      
            writeFile.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred when writing invoice file.");
            e.printStackTrace();
        }
        
        
        
    }
}
