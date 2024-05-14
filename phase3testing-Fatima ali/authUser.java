


//Fatima ali ahmed 202004905 
package phase3testing;
public class authUser {
    private String username;
    private String password;

    public authUser(String un, String p) {
        un = username;
        p = password;
    }

    public boolean authenticate() {

        return !username.isEmpty() && !password.isEmpty();
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }

    public static void main(String[] args) {
        authUser auth = new authUser("john_doe", "pa$$w0rd111");
        if (auth.authenticate()) {
            System.out.println("Authentication successful.");
            auth.logout();
        } else {
            System.out.println("Authentication failed.");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

public void changePassword(String newPassword) {
    this.password = newPassword;
    System.out.println("Password changed successfully.");
}


    
}

