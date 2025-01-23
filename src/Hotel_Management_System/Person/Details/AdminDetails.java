package Hotel_Management_System.Person.Details;

public class AdminDetails {
    String username,password;
    public AdminDetails(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}
}
