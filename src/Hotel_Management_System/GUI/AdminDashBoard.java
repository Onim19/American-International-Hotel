package Hotel_Management_System.GUI;

import Hotel_Management_System.Person.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashBoard extends JFrame implements ActionListener {
    JButton btnEmployee,btnRoom,btnStaff,btnGuest,LogOut;

    public AdminDashBoard() {
        super.getContentPane().setBackground(Color.LIGHT_GRAY);
        super.setSize(1280, 720);
        super.setLocation(150, 50);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        ImageIcon icon=new ImageIcon("src/img/Icon.png"); //Icon
        super.setIconImage(icon.getImage()); //Adding icon
        super.setTitle("Admin Dashboard");

        // Adding Background Image
        ImageIcon image1=new ImageIcon("src/img/AdminDashboard.jpg");
        Image image2=image1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        JLabel image=new JLabel(image3);
        image.setBounds(0,0,1280,720);
        super.add(image);

        // Common font for button labels
        Font buttonFont=new Font("Arial", Font.BOLD, 14);

        // Adding Employee button with label
        ImageIcon employee1=new ImageIcon("src/img/Employee.png");
        Image employee2=employee1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon employee3=new ImageIcon(employee2);
        btnEmployee=new JButton("Employee", employee3);
        btnEmployee.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEmployee.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEmployee.setBounds(20, 500, 140, 160);
        btnEmployee.setFocusable(false);
        btnEmployee.setBackground(Color.BLACK);
        btnEmployee.setForeground(Color.WHITE);
        btnEmployee.setFont(buttonFont);
        btnEmployee.addActionListener(this);
        image.add(btnEmployee);

        // Adding Room button with label
        ImageIcon room1=new ImageIcon("src/img/Room.png");
        Image room2=room1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon room3=new ImageIcon(room2);
        btnRoom=new JButton("Room", room3);
        btnRoom.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnRoom.setHorizontalTextPosition(SwingConstants.CENTER);
        btnRoom.setBounds(180, 500, 140, 160);
        btnRoom.setFocusable(false);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        btnRoom.setFont(buttonFont);
        btnRoom.addActionListener(this);
        image.add(btnRoom);

        // Adding Staff button with label
        ImageIcon staff1=new ImageIcon("src/img/Staff.png");
        Image staff2=staff1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon staff3=new ImageIcon(staff2);
        btnStaff=new JButton("Staff", staff3);
        btnStaff.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnStaff.setHorizontalTextPosition(SwingConstants.CENTER);
        btnStaff.setBounds(500, 500, 140, 160);
        btnStaff.setFocusable(false);
        btnStaff.setBackground(Color.BLACK);
        btnStaff.setForeground(Color.WHITE);
        btnStaff.setFont(buttonFont);
        btnStaff.addActionListener(this);
        image.add(btnStaff);

        // Adding Guest button with label
        ImageIcon guest1=new ImageIcon("src/img/Guest.png");
        Image guest2=guest1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon guest3=new ImageIcon(guest2);
        btnGuest=new JButton("Guest", guest3);
        btnGuest.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnGuest.setHorizontalTextPosition(SwingConstants.CENTER);
        btnGuest.setBounds(340, 500, 140, 160);
        btnGuest.setFocusable(false);
        btnGuest.setBackground(Color.BLACK);
        btnGuest.setForeground(Color.WHITE);
        btnGuest.setFont(buttonFont);
        btnGuest.addActionListener(this);
        image.add(btnGuest);

        //Adding a logout button
        LogOut=new JButton("Log out");
        LogOut.setBounds(1050,600,150,50);
        LogOut.setFocusable(false);
        LogOut.setBackground(Color.RED);
        LogOut.setFont(new Font("Arial", Font.BOLD, 22));
        LogOut.setForeground(Color.WHITE);
        LogOut.addActionListener(this);
        image.add(LogOut);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==LogOut){
            int response=JOptionPane.showConfirmDialog(this,"Logout?","Confirm Log Out",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION){
                super.dispose();
                new Welcome();
            }
        }
        else if(e.getSource()==btnEmployee) {
            super.dispose();
            new Employee();
        }
        else if(e.getSource()==btnStaff) {
            super.dispose();
            new Staff();
        }
    }

    public static void main(String[] args) {
        new AdminDashBoard();
    }
}
