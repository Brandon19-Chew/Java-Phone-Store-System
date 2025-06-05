package Classes;


public class DeliveryOrder extends Document {
    
    private PurchaseOrder po;
    
    public DeliveryOrder() {
        super(null, null, false);
    }

    public DeliveryOrder(String id, PurchaseOrder PO, String date, boolean status) {
        super(id, date, status);
        this.po = PO;
       
    }

    public PurchaseOrder getPO() {
        return po;
    }

    public void setPO(PurchaseOrder PO) {
        this.po = PO;
    }

    @Override
    public String toString() {
        return getNumber() + "|" + getPO().getNumber() + "|" + getDate() + "|" + getStatus();
    }
     
    
}
