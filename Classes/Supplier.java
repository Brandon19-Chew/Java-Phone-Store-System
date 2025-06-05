package Classes;
import java.util.Arrays;

/**
 *
 * @author chin wee jian
 */

public class Supplier {

    private String supplierID;
    private String supplierName;
    private String email;
    private String phoneNo;
    private String address;
    private Product[] productList;

    public Supplier(){
        
    }
    
    public Supplier(String supplierID, String supplierName, String email, String phoneNo, String address, Product[] productList) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address; 
        this.productList = productList;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public Product[] getProductList() {
        return productList;
    }
    
        public String getProductID(int index){
        return productList[index].getProductId();
    }    
    
    public String getProductName(int index){
        return productList[index].getProductName();
    }    
    
    public double getProductPrice(int index){
        return productList[index].getPrice();
    }

    public void setProductList(Product[] product) {
        this.productList = product;
    }

    public void setProductID(String productID, int index){
        this.productList[index].setProductId(productID);
    }
    
    public void setProductName(String productName, int index){
        this.productList[index].setProductName(productName);
    }
    
    public void setProductPrice(double price, int index){
        this.productList[index].setPrice(price);
    }
    
    public void addProduct(Product product, int index) {
    
        if (index >= 0 && index < productList.length) {
            productList[index] = product;
        } else {
            System.out.println("Index out of bounds.");
        }
    }
    
    public void removeProduct(int index){
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
        
       Product[] newProductList = new Product[productList.length - 1];
        for (int i = 0, j = 0; i < productList.length; i++) {
            if (i != index) {
                newProductList[j] = productList[i];
                j++;
            }
        }
        
        productList = newProductList; // Update the product list

        
    }

    
    @Override        
    public String toString() {
        
        return supplierID + "|" + supplierName + "|" + phoneNo + "|" + email + "|" + address + "|" + Arrays.toString(productList)+ "\n";
    }    
    
}

