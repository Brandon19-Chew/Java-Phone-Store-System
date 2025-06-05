package Classes;

public class Product {
        
    private String productId;
    private String productName;
    private double price;
    
    public Product(){
        this.productId = null;
        this.productName = null;
        this.price = 0d;
    }

    // Constructor
    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    


    @Override
    public String toString() {
        return productId + "," + productName + "," + price ;
    } 
    
}