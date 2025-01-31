package Hotel_Management_System.Room;

//import Hotel_Management_System.Room.RoomDetails.PremiumRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Room extends JFrame implements ActionListener {
    JButton btnpremium, btnvip, btngeneral;

    public Room() {
        super.getContentPane().setBackground(Color.LIGHT_GRAY);
        super.setSize(720, 540);
        super.setLocationRelativeTo(null); // Centers the window
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        ImageIcon icon = new ImageIcon("src/img/Icon.png"); // Icon
        super.setIconImage(icon.getImage()); // Adding icon
        super.setTitle("Room Details");

        int buttonWidth = 200;
        int buttonHeight = 40;
        int centerX = (720 - buttonWidth) / 2; // Centering logic

        btnpremium = new JButton("Premium Rooms");
        btnpremium.setBounds(centerX, 260,buttonWidth,buttonHeight);
        btnpremium.setFocusable(false);
        btnpremium.addActionListener(this);
        super.add(btnpremium);

        btnvip = new JButton("VIP Rooms");
        btnvip.setBounds(centerX, 200,buttonWidth,buttonHeight);
        btnvip.setFocusable(false);
        btngeneral.addActionListener(this);
        super.add(btnvip);

        btngeneral = new JButton("General Rooms");
        btngeneral.setBounds(centerX, 320,buttonWidth,buttonHeight);
        btngeneral.setFocusable(false);
        btngeneral.addActionListener(this);
        super.add(btngeneral);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* if(e.getSource()==btnvip){
            new PremiumRoom(false);
        }
       else if(e.getSource()==btnpremium){
            new PremiumRoom();
        }
        else if(e.getSource()==btngeneral){
            new GeneralRoom();
        } */
    }

    public static void main(String[] args) {
        new Room();
    }
}
