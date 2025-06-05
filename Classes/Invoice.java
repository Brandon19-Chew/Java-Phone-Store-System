
package Classes;


public class Invoice extends Document {
    
    private double amountDue;
    
    public Invoice(){
        super(null, null, false);
        this.amountDue = 0d;
    }

    public Invoice(String invoiceNumber,String invoiceDate,boolean status, double amountDue) {
        super(invoiceNumber, invoiceDate, status);
        this.amountDue = amountDue;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }


    @Override
    public String toString() {
        return getNumber() + "|" + getDate() + "|" + amountDue + "|" + getStatus();
    }
       
}
