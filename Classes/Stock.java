package Classes;


public class Stock {
    
    private String category;
    private String productID;
    private String productName;
    private int quantity;

    public Stock(String category, String productID, String productName, int quantity) {
        this.category = category;
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" + "category=" + category + ", productID=" + productID + ", productName=" + productName + ", quantity=" + quantity + '}';
    }
    
    
}
