package Hotel_Management_System.Person.Details;

public class EmployeeDetails {
    private String id,name,age,gender,job,phone,salary;
    public EmployeeDetails(String id,String name,String age,String gender,String job,String salary,String phone) {
        this.id=id;
        this.name = name;
        this.age=age;
        this.gender=gender;
        this.job=job;
        this.salary=salary;
        this.phone=phone;
    }
    //adding getter methods for private attributes
    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public String getAge(){return this.age;}
    public String getGender(){return this.gender;}
    public String getJob(){return this.job;}
    public String getSalary(){return this.salary;}
    public String getPhone(){return this.phone;}
}
