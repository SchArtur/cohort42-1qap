package app.demowebshop.data;

public class User {

    private String FirstName;

    private String LastName;
    private String email;
    private String password;


    public User(String FristName, String LastName,  String email, String password) {
        this.FirstName = FristName;
        this.LastName = LastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}