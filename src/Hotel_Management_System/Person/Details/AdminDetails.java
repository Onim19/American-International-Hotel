package Hotel_Management_System.Person.Details;

public class AdminDetails {
    private String username,email,phone,password;
    public AdminDetails(String username,String email,String phone,String password){
        this.username=username;
        this.email=email;
        this.phone=phone;
        this.password=password;
    }
    public String getUsername(){return this.username;}
    public String getEmail(){return this.email;}
    public String getPhone(){return this.phone;}
    public String getPassword(){return this.password;}
}
