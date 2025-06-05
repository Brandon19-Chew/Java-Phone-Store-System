

package Modules;

import Classes.Payment;
import Data.Validation.PODataValidation;
import java.util.ArrayList;
import Classes.PurchaseOrder;
import Utility.DateGenerator;
import Utility.ArrayListLoader;
import Utility.ArrayListSaver;
import Utility.IO;
import Utility.SystemInput;
import View.PurchaseOrderView;

public class PaymentModule {
    
    private static ArrayList<PurchaseOrder> currentBills = new ArrayList<>();
    private static ArrayList<Payment> paymentHistory = new ArrayList<>();  
    
    
    public static void payBill() {
        
        String poNum;
        String paymentMethod = new String();
        String paymentDate = new String();
        boolean status = true;
      
        currentBills = ArrayListLoader.loadPOList();
        
        PurchaseOrderView.viewProcessingPO();

        int index = 0;
        
        do{
            
            System.out.print("Please enter the PO number : ");
             poNum = IO.getScanner().nextLine();
             
             for(PurchaseOrder po:currentBills){
                 
             if(po.getNumber().equals(poNum))
                 break;
             
             index++;
             
             }
             
             if(currentBills.get(index).getStatus())
                 System.out.println("This PO is already paid, Please Try Again");
                          
        }while(!PODataValidation.checkProcPoNoExistence(poNum));
        
        double totalPrice = currentBills.get(index).getTotalPrices();
        
        System.out.println("=============Payment Method===============");
        System.out.println("|    1. Cash                             |");
        System.out.println("|    2. Bank Transfer                    |");
        System.out.println("|    3. Credit Cards                     |");
        System.out.println("|    4. Cheque Payment                   |");
        System.out.println("==========================================");
        
        int action;
        int ask;
        
        do {
            action = SystemInput.inputForInt();


            switch(action) {
                case 1:
                    paymentMethod = "Cash";
                    break;
                case 2:
                    paymentMethod = "Bank Transfer";
                    System.out.print("Enter you Bank Account ID: ");
                    ask = IO.getScanner().nextInt();
                    break; 
                case 3:
                   paymentMethod = "Credit cards";
                    break;
                case 4:
                    paymentMethod = "Cheque Payment";
                    break;

                default:
                    System.out.println("Invalid option. Please try Again");
            }  
        }while(action > 4 || action < 1);
       
        System.out.println("Amount: " + totalPrice);
                
        if(SystemInput.checkInputCondition("Do you sure you want to pay? (y/n) : ")){
            String currentDate = DateGenerator.getCurrentDate();
            Payment paid = new Payment(poNum, currentDate, paymentMethod, paymentDate, status); 
            System.out.println("Payment Successful");
            currentBills.get(index).setStatus(true);            
            
            
            paymentHistory.add(paid);
            ArrayListSaver.savePOList(currentBills);
            ArrayListSaver.savePaymentList(paymentHistory);
            
        }else{
            System.out.print("Payment Cancelled");
        }
                
    }
    
    public static void checkPaymentHistory() {  
    System.out.println("Payment History:");  
    System.out.println("======================================================================");  
    System.out.printf("| %-10s | %-20s | %-15s | %-10s \n", "PO Number", "Payment Method", "Payment Date", "Status");  
    System.out.println("======================================================================");  
    
    for (Payment payment : paymentHistory) {  
        String poNumber = payment.getNumber();  
        String paymentMethod = payment.getPaymentMethod();  
        String dueDate = payment.getDate();  
        String status = payment.getStatus() ? "Paid" : "Unpaid"; 
        
        System.out.printf("| %-10s | %-20s | %-15s | %-10s \n", poNumber, paymentMethod, dueDate, status);  
    }  
    
    System.out.println("=======================================================================");  
    }
    
    public static void checkCurrentBills() {
    
        currentBills = ArrayListLoader.loadPOList();  
        System.out.println("Unpaid Bills:");  
        for (PurchaseOrder po : currentBills) {  
            if (!po.getStatus()) {  
                System.out.println("PO Number: " + po.getNumber() + ", Supplier: " + po.getSupplier().getSupplierName()+ ", Due Date: " + po.getDate() + ", Amount: " + po.getTotalPrices());  
            }  
        } 
    }
}

