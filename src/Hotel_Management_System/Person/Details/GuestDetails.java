package Hotel_Management_System.Person.Details;

public class GuestDetails {
    private String room,type,name,age,gender,job,contact;
    private double payment,staying_day;
    public GuestDetails(String room,String type, String name, String age, String gender, String job,
                        String contact, double payment, double staying_day) {
        this.room = room;
        this.type=type;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.job = job;
        this.contact = contact;
        this.payment = payment;
        this.staying_day = staying_day;
    }
    public void setPaymentwService(double service){
        this.payment=getPayment()+service;
    }
    public String getRoom(){return this.room;}
    public String getType(){return this.type;}
    public String getName(){return this.name;}
    public String getAge(){return this.age;}
    public String getGender(){return this.gender;}
    public String getJob(){return this.job;}
    public String getContact(){return this.contact;}
    public double getPayment(){return this.payment;}
    public double getStayingDay(){return this.staying_day;}
}
