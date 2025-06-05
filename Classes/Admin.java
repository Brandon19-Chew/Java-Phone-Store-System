package Classes;

public class Admin {
    private final int id;
    private final String username;
    private final String password;
    private boolean loggedIn;
    private Admin loggedInAdmin;

    // Constructor
    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
     public boolean isLoggedIn() {
        return loggedIn;
    }

    public Admin getLoggedInAdmin() {
        return loggedInAdmin;
    }
    
}
