package Hotel_Management_System.Person;

import Hotel_Management_System.GUI.Admin;
import Hotel_Management_System.GUI.AdminDashBoard;
import Hotel_Management_System.Person.Details.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class RegisterAdmin extends JFrame implements ActionListener {
    JLabel lblRegisterHere,lblUsername,lblEmail,lblPhone,lblPassword,lblConfirmPassword;
    JTextField txtUsername,txtEmail,txtPhone;
    JPasswordField txtPassword,txtConfirmPassword;
    JButton btnSubmit,btnClear,btnGoBack;

    public RegisterAdmin(){
        super.getContentPane().setBackground(Color.LIGHT_GRAY);
        super.setSize(720,540);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        ImageIcon icon=new ImageIcon("src/img/Icon.png");//Icon
        ImageIcon login_bg1=new ImageIcon("src/img/Registration.png");
        super.setIconImage(icon.getImage());//adding icon
        super.setTitle("Register");

        //Pre-sizing the image
        Image login_bg2=login_bg1.getImage().getScaledInstance(720,540,Image.SCALE_DEFAULT);
        ImageIcon login_bg=new ImageIcon(login_bg2);

        //Adding a label for background image
        JLabel l_bg=new JLabel(login_bg);
        l_bg.setBounds(0,0,720,540);

        //Title Label
        lblRegisterHere=new JLabel("Register Here");
        lblRegisterHere.setBounds(150,20,280,40);
        lblRegisterHere.setFont(new Font("Arial",Font.BOLD,28));
        lblRegisterHere.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegisterHere.setForeground(Color.BLACK);
        l_bg.add(lblRegisterHere);

        //Labels and text fields for form input
        lblUsername=new JLabel("Username:");
        lblUsername.setBounds(50,90,140,30);
        lblUsername.setFont(new Font("Arial",Font.BOLD,16));
        l_bg.add(lblUsername);

        txtUsername=new JTextField();
        txtUsername.setBounds(200,90,220,30);
        l_bg.add(txtUsername);

        lblEmail=new JLabel("Email:");
        lblEmail.setBounds(50,140,140,30);
        lblEmail.setFont(new Font("Arial",Font.BOLD,16));
        l_bg.add(lblEmail);

        txtEmail=new JTextField();
        txtEmail.setBounds(200,140,220,30);
        l_bg.add(txtEmail);

        lblPhone=new JLabel("Phone:");
        lblPhone.setBounds(50,190,140,30);
        lblPhone.setFont(new Font("Arial",Font.BOLD,16));
        l_bg.add(lblPhone);

        txtPhone=new JTextField();
        txtPhone.setBounds(200,190,220,30);
        l_bg.add(txtPhone);

        lblPassword=new JLabel("Password:");
        lblPassword.setBounds(50,240,140,30);
        lblPassword.setFont(new Font("Arial",Font.BOLD,16));
        l_bg.add(lblPassword);

        txtPassword=new JPasswordField();
        txtPassword.setBounds(200,240,220,30);
        l_bg.add(txtPassword);

        lblConfirmPassword=new JLabel("Confirm Password:");
        lblConfirmPassword.setBounds(50,290,160,30);
        lblConfirmPassword.setFont(new Font("Arial",Font.BOLD,16));
        l_bg.add(lblConfirmPassword);

        txtConfirmPassword=new JPasswordField();
        txtConfirmPassword.setBounds(200,290,220,30);
        l_bg.add(txtConfirmPassword);

        //Buttons
        btnSubmit=new JButton("Submit");
        btnSubmit.setBounds(200,350,100,40);
        btnSubmit.setFont(new Font("Arial",Font.BOLD,14));
        btnSubmit.setBackground(Color.GREEN);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFocusable(false);
        btnSubmit.addActionListener(this);
        l_bg.add(btnSubmit);

        btnClear=new JButton("Clear");
        btnClear.setBounds(320,350,100,40);
        btnClear.setFont(new Font("Arial",Font.BOLD,14));
        btnClear.setBackground(Color.RED);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFocusable(false);
        btnClear.addActionListener(this);
        l_bg.add(btnClear);

        btnGoBack=new JButton("Go Back");
        btnGoBack.setBounds(260,410,100,40);
        btnGoBack.setFont(new Font("Arial",Font.BOLD,14));
        btnGoBack.setBackground(Color.BLUE);
        btnGoBack.setForeground(Color.WHITE);
        btnGoBack.setFocusable(false);
        btnGoBack.addActionListener(this);
        l_bg.add(btnGoBack);

        //Setting layout manager to null for background label
        l_bg.setLayout(null);
        super.add(l_bg);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSubmit){
            Register();
        }
        else if(e.getSource()==btnClear){
            txtUsername.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtPassword.setText("");
            txtConfirmPassword.setText("");
        }
        else if(e.getSource()==btnGoBack){
            super.dispose();
            new AdminDashBoard();
        }
    }

    public void Register(){
        String username=txtUsername.getText();
        String email=txtEmail.getText();
        String phone=txtPhone.getText();
        String password;
        String pass=new String(txtPassword.getPassword());
        String c_pass=new String(txtConfirmPassword.getPassword());
        if(username.isEmpty()){
            JOptionPane.showMessageDialog(this,"Username can not be empty!");
            txtUsername.requestFocus();
            return;
        }
        if(!(email.contains("@")  && email.contains(".com"))){
            JOptionPane.showMessageDialog(this,"Enter a valid email!");
            txtEmail.requestFocus();
            return;
        }
        if (phone.length() != 11 || !phone.matches("\\d+")) {
            JOptionPane.showMessageDialog(this,"Enter a valid phone number!");
            txtPhone.requestFocus();
            return;
        }
        if(pass.equals(c_pass) && !(pass.isEmpty()) && !(c_pass.isEmpty())){
            password=pass;
        }
        else{
            JOptionPane.showMessageDialog(this,"Password not matched");
            txtPassword.requestFocus();
            return;
        }
        AdminDetails user=new AdminDetails(username,email,phone,password);

        //exception handling and file handling for database
        try{
            File file=new File("src/Hotel_Management_System/Person/Details/TextFiles/AdminDetails.txt");
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String line;
            while((line=reader.readLine())!=null){
                String[]parts=line.split(",");
                if(parts[0].equals(username) || parts[1].equals(email) || parts[2].equals(phone)){
                    JOptionPane.showMessageDialog(this,"Admin exists!");
                    reader.close();
                    return;
                }
            }
            reader.close();
            FileWriter writer=new FileWriter("src/Hotel_Management_System/Person/Details/TextFiles/AdminDetails.txt",true);
            writer.write(user.getUsername()+","+user.getEmail()+","+user.getPhone()+","+ user.getPassword()+"\n");
            writer.close();
            JOptionPane.showMessageDialog(this,"Registered Successfully!");
            super.dispose();
            new Admin();
        }
        catch(IOException ae){
            ae.printStackTrace();
        }
    }
}
