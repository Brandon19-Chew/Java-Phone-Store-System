
package File.Reader;

import Classes.PurchaseOrder;
import Classes.DeliveryOrder;
import Utility.DocumentStatus;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class DeliveryFileReader {
    
    public static ArrayList<DeliveryOrder> readDeliveryFile(String filePath){
        
         ArrayList<DeliveryOrder> doList = new ArrayList<>();       
       
        String doNum;
        String date;
        boolean status;
   
        try(FileReader readFile = new FileReader(filePath)){
                
            Scanner fileRead = new Scanner(readFile);
            
            //when scanner has scanned next line
            while (fileRead.hasNextLine()) {
                String line = fileRead.nextLine();
                //split the text file to supplier class                
                //tempolary save to local array
                String[] splitCount = line.split("\\|");
                                
                if(splitCount.length == 4){

                    // Create a new Supplier object for each line
                    PurchaseOrder po = new PurchaseOrder();
                    
                    //split the array to correnspond variable
                    doNum = splitCount[0];
                    po.setNumber(splitCount[1]);
                    date = splitCount[2];
                    status = DocumentStatus.checkStatus(splitCount[3]);
                    
                    
                    //save to Supplier class
                    doList.add(new DeliveryOrder(doNum, po , date, status ));

                }                
                               
            }
            fileRead.close();
        
        } catch (IOException e) {
            System.out.println("An error occurred when reading supplier file.");
            e.printStackTrace();
        }
        
        System.out.println(doList);
       
        return doList;
    }
    
}
