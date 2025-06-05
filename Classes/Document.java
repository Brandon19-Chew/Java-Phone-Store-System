
package Classes;

public class Document {

    private String number;
    private String date;
    private boolean status;
    
    public Document(String number, String date, boolean status){
        
        this.number = number;
        this.date = date;
        this.status = status;
               
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
