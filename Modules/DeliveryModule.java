
package Modules;
import Classes.DeliveryOrder;
import Utility.*;
import java.util.ArrayList;

public class DeliveryModule {
    
    private static ArrayList<DeliveryOrder> doList;
    
    public static void displayDeliveryStatus() {
        
        doList = ArrayListLoader.loadDOList();
        
        System.out.println("=============================================================");
        System.out.printf("|  %s  |  %5s  |  %-10s  |   %5s  \n", "DO Number", "PO Number","DO Date",  "Status");
        System.out.println("=============================================================");
        
        
        for(DeliveryOrder de: doList) {
         
            String doNum = de.getNumber();
            String poNum = de.getPO().getNumber();
            String deliveryDate = de.getDate();
            String status = DocumentStatus.poStatus(de.getStatus());
            
            System.out.printf("|    %5s   |   %-7s   |    %-10s  |  %10s  \n", doNum, poNum, deliveryDate, status);
        }
        
        System.out.println("=============================================================");
    }

      
}
