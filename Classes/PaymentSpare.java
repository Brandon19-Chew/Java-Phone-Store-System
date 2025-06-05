package Classes;


public class PaymentSpare{
    
    private PurchaseOrder po;
    private String paymentDate;
    private String paymentMethod;

    public PaymentSpare(){
        this.po = null;
        this.paymentDate = null;
        this.paymentMethod = null;
    }
    
    public PaymentSpare(PurchaseOrder po, String paymentDate, String paymentMethod) {
        this.po = po;
        this.paymentDate = paymentDate;
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
        return paymentDate + "|" + po + "|" + paymentMethod;
    }
   
}
