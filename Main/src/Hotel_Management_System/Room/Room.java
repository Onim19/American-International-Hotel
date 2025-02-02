package Hotel_Management_System.Room;

import Hotel_Management_System.GUI.AdminDashBoard;
import Hotel_Management_System.Room.RoomDetails.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room extends JFrame implements ActionListener {
    JButton btnpremium,btnvip,btngeneral,back;

    public Room() {
        super.getContentPane().setBackground(Color.LIGHT_GRAY);
        super.setSize(720, 580);
        super.setLocationRelativeTo(null); // Centers the window
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        ImageIcon icon = new ImageIcon("src/img/Icon.png"); // Icon
        super.setIconImage(icon.getImage()); // Adding icon
        super.setTitle("Room Details");

        // Adding Background Image
        ImageIcon image1=new ImageIcon("src/img/Room.jpg");
        Image image2=image1.getImage().getScaledInstance(720,580,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        JLabel image=new JLabel(image3);
        image.setBounds(0,0,720,580);
        super.add(image);

        int buttonWidth = 200;
        int buttonHeight = 40;
        int centerX = (720 - buttonWidth) / 2; // Centering logic

        btnpremium = new JButton("Premium Rooms");
        btnpremium.setBounds(centerX, 260,buttonWidth,buttonHeight);
        btnpremium.setFocusable(false);
        btnpremium.addActionListener(this);
        image.add(btnpremium);

        btnvip = new JButton("VIP Rooms");
        btnvip.setBounds(centerX, 200,buttonWidth,buttonHeight);
        btnvip.setFocusable(false);
        btnvip.addActionListener(this);
        image.add(btnvip);

        btngeneral = new JButton("General Rooms");
        btngeneral.setBounds(centerX, 320,buttonWidth,buttonHeight);
        btngeneral.setFocusable(false);
        btngeneral.addActionListener(this);
        image.add(btngeneral);

        back = new JButton("Back");
        back.setBounds(310, 380,100,buttonHeight);
        back.setFocusable(false);
        back.addActionListener(this);
        image.add(back);


        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnvip){
           super.dispose();
           new VipRoom();
       }
       else if(e.getSource()==btnpremium){
           super.dispose();
           new PremiumRoom();
       }
       else if(e.getSource()==btngeneral){
           super.dispose();
           new GeneralRoom();
       }
       else if(e.getSource()==back){
           super.dispose();
           new AdminDashBoard();
       }
    }
}
