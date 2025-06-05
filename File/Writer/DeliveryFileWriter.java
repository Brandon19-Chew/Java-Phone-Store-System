
package File.Writer;

import Classes.PurchaseOrder;
import Classes.DeliveryOrder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DeliveryFileWriter {
    
    //write into PurchaseOrder.txt
    public static void writeDOFile(String filePath, ArrayList<DeliveryOrder> doList){

        try(FileWriter writeFile = new FileWriter(filePath)){
            
            for(DeliveryOrder Do : doList){
            
                           
                String doNum = Do.getNumber();
                String date = Do.getDate();
                PurchaseOrder po = Do.getPO();
                boolean status = Do.getStatus();

                String format = doNum + "|" + po.getNumber()+ "|" + date + "|" + status + "\n";
                
                writeFile.write(format);
        }
                                      
            writeFile.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred when writing supplier file.");
            e.printStackTrace();
        }
        
        
        
    }
}
