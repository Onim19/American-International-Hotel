package Hotel_Management_System.GUI;

import Hotel_Management_System.Room.RoomDetails.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRoom implements ActionListener {
    JButton vipButton,premiumButton,generalButton,back;
    JFrame frame;
    DefaultTableModel model;
    JScrollPane currentScrollPane;
    JLabel select_room;

    // Constructor
    public BookRoom() {
        // Create the frame
        frame = new JFrame("Book Room");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLocationRelativeTo(null);
        ImageIcon icon=new ImageIcon("src/img/Icon.png"); //Icon
        frame.setIconImage(icon.getImage()); //Adding icon
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Set layout to BoxLayout (vertical alignment)
        frame.setLayout(null);
        Font font = new Font("Sherif", Font.BOLD, 20);

        // Adding Background Image
        ImageIcon image1=new ImageIcon("src/img/BookRoom.jpg");
        Image image2=image1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(image2);

        JLabel image=new JLabel(image3);
        image.setBounds(0,0,1280,720);
        frame.add(image);

        //adding a label to for select buttons
        JLabel select=new JLabel("Select Type");
        select.setBounds(200,120,200,50);
        select.setFont(new Font("Arial",Font.BOLD,30));
        image.add(select);

        // Create buttons with styles
        vipButton = new JButton("VIP 6000-8000Tk");
        vipButton.setFocusable(false);
        vipButton.setFont(font);
        vipButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the button
        vipButton.setBounds(72,185,450,50);
        vipButton.setBackground(Color.decode("#8B4513"));
        vipButton.setForeground(Color.WHITE);
        vipButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        vipButton.addActionListener(this);

        premiumButton = new JButton("Premium 3500-5000Tk");
        premiumButton.setFocusable(false);
        premiumButton.setFont(font);
        premiumButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        premiumButton.setBounds(72,265,450,50);
        premiumButton.setBackground(Color.decode("#8B4513"));
        premiumButton.setForeground(Color.WHITE);
        premiumButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        premiumButton.addActionListener(this);

        generalButton = new JButton("General 1500-2000Tk");
        generalButton.setFocusable(false);
        generalButton.setFont(font);
        generalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generalButton.setBounds(72,345,450,50);
        generalButton.setBackground(Color.decode("#8B4513"));
        generalButton.setForeground(Color.WHITE);
        generalButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        generalButton.addActionListener(this);

        back = new JButton("Back");
        back.setFocusable(false);
        back.setFont(font);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setBounds(251,445,100,50);
        back.setBackground(Color.decode("#8B4513"));
        back.setForeground(Color.WHITE);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);

        image.add(vipButton);
        image.add(premiumButton);
        image.add(generalButton);
        image.add(back);

        // Make the frame visible
        frame.setVisible(true);
    }


    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentScrollPane != null) {
            frame.remove(currentScrollPane);
        }
        if(e.getSource()==vipButton) {;
            currentScrollPane=new VipRoom(frame).Guest_Frame("VIP",frame);
            frame.add(currentScrollPane);
        }
        if(e.getSource() == premiumButton) {
            currentScrollPane=new PremiumRoom(frame).Guest_Frame("PREMIUM",frame);
            frame.add(currentScrollPane);
        }
        if(e.getSource() == generalButton) {
            currentScrollPane=new GeneralRoom(frame).Guest_Frame("GENERAL",frame);
            frame.add(currentScrollPane);
        }
        else if(e.getSource()==back){
            frame.dispose();
            new Welcome();
        }
    }


    // Main method to run the program
    public static void main(String[] args) {
        new BookRoom(); // Create an instance of BookRoom, which calls the constructor
    }
}