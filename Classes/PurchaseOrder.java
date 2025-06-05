
package Classes;

import java.util.HashMap;


public class PurchaseOrder extends Document {

    private Supplier supplier;
    private HashMap<Product, Integer> stocks;
    private double totalPrices;

    public PurchaseOrder(){
        super(null, null, false);
        this.stocks = new HashMap<>();
        this.totalPrices = 0d;
    }
    
    public PurchaseOrder(String poNumber, String poDate, boolean status) {
        super(poNumber, poDate, status);
        this.stocks = new HashMap<>();
    }
    
    public PurchaseOrder(String poNumber, String poDate, boolean status, HashMap<Product, Integer> stocks, double totalPrices){
        super(poNumber, poDate, status);
        this.stocks = stocks;
        this.totalPrices = totalPrices;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void addProduct(Product product, int quantity) {
        stocks.put(product, stocks.getOrDefault(product, 0) + quantity);
    }

    public HashMap<Product, Integer> getStocks() {
        return stocks;
    }
    
    public int getProductQuantity(Product product){
        
        return stocks.get(product);
    }
    
    public double getTotalPricesByProduct(Product product){
        
        totalPrices = getProductQuantity(product) * product.getPrice();
        
        return totalPrices;
    }

    public double getTotalPrices() {
        return totalPrices;
    }
    
    public void setTotalPrices(double totalPrices) {
        this.totalPrices = totalPrices;
    }
    
    @Override
    public String toString() {
        return getNumber() + "|" + getDate() + "|" + supplier + "|" + getStocks()  + "|" + totalPrices + "|" + getStatus() + "\n";
    }

}
