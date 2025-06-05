package Classes;

public class Payment extends Document{
    
    
    private String paymentDate;
    private PurchaseOrder po;
    private String paymentMethod;

    public Payment(){
        super(null,null,false);
        this.paymentDate = null;
        this.paymentMethod = null;
        this.po = null;
    }

    public Payment(String Id  , String dueDate, String paymentMethod, String paymentDate, boolean status) {
        super(Id, dueDate,status);
        this.paymentDate = paymentDate;
        this.po = po;
        this.paymentMethod = paymentMethod;
    }
    

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PurchaseOrder getPo() {
        return po;
    }

    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" + "Id " + getNumber() + ", Due Date" + getDate() + ", payment Method" + paymentMethod + ", payment Date" + paymentDate + ", Status" + getStatus() + '}';
    }

    
   
    
   
}
