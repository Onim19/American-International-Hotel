package Hotel_Management_System.GUI;
import Hotel_Management_System.Person.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Admin extends JFrame implements ActionListener{
    JTextField userName;
    JPasswordField passWord;
    JButton Login,Cancel;

    public Admin() {
        super.getContentPane().setBackground(Color.LIGHT_GRAY);
        super.setSize(1280,720);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        ImageIcon icon=new ImageIcon("src/img/Icon.png");//Icon
        ImageIcon login_bg1=new ImageIcon("src/img/Login_bg.png");
        super.setIconImage(icon.getImage());//adding icon
        super.setTitle("Log in");

        //pre-sizing the image
        Image login_bg2=login_bg1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon login_bg=new ImageIcon(login_bg2);

        //adding a label for adding background image
        JLabel l_bg=new JLabel(login_bg);
        l_bg.setBounds(0,0,1280,720);
        super.add(l_bg);

        //adding a picture
        ImageIcon picture1=new ImageIcon("src/img/Login.png");
        Image picture2=picture1.getImage().getScaledInstance(610,418,Image.SCALE_DEFAULT);
        ImageIcon picture3=new ImageIcon(picture2);
        JLabel picture=new JLabel(picture3);
        picture.setBounds(700,150,610,418);
        l_bg.add(picture);
        //adding label for user name
        JLabel user_name=new JLabel("Username : ");
        user_name.setBounds(200,250,100,30);//adjusted position
        user_name.setForeground(Color.WHITE);//set label color to white
        l_bg.add(user_name);

        //adding textbox for username
        userName=new JTextField();
        userName.setBounds(325,250,250,30);
        l_bg.add(userName);

        //adding label for password
        JLabel password=new JLabel("Password  : ");
        password.setBounds(200,300,100,25);//adjusted position
        password.setForeground(Color.WHITE);//set label color to white
        l_bg.add(password);

        //adding textbox for password
        passWord=new JPasswordField();
        passWord.setBounds(325,300,250,25);
        l_bg.add(passWord);

        //login button
        Login=new JButton("Log in");
        Login.setBounds(360,350,70,30);
        Login.setFocusable(false);
        Login.setBackground(Color.WHITE);//set background color to white
        Login.setForeground(Color.BLACK);//set font color to black
        Login.addActionListener(this);
        Login.setFont(new Font("Serif",Font.BOLD,12));
        l_bg.add(Login);

        //cancel button
        Cancel=new JButton("Cancel");
        Cancel.setBounds(460,350,70,30);
        Cancel.setFocusable(false);
        Cancel.setBackground(Color.WHITE);//set background color to white
        Cancel.setForeground(Color.BLACK);//set font color to black
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Serif",Font.BOLD,12));
        l_bg.add(Cancel);


        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Login) {
            admin();
        } else if(e.getSource()==Cancel) {
            super.dispose();
            new Welcome();
        }
    }

    public void admin(){
        String username=userName.getText();
        String password=new String(passWord.getPassword());
        try {
            File file=new File("src/Hotel_Management_System/Person/Details/TextFiles/AdminDetails.txt");
            if(!file.exists()){
                JOptionPane.showMessageDialog(null,"No user is registered!");
                return;
            }
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String line;
            boolean loggedin=false;
            while((line=reader.readLine())!=null){
                String[] parts=line.split(",");
                if((parts[0].equals(username)||parts[1].equals(username)||parts[2].equals(username))&&parts[3].equals(password)){
                    loggedin=true;
                    break;
                }
            }
            reader.close();
            if(loggedin){
                JOptionPane.showMessageDialog(this,"Login successful");
                super.dispose();
                new AdminDashBoard();
            }
            else {
                JOptionPane.showMessageDialog(this,"Invalid username or password");
                return;
            }
        }
        catch(IOException ae){
            ae.printStackTrace();
        }
    }
}
